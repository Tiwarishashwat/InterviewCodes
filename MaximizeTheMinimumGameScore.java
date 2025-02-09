//explanation
/*
Question will be solved using binary search on answer concept.
If a value mid is achievable, then any value smaller than mid is also achievable.
If a value mid is not achievable, then any value larger than mid is also not achievable.

We are searching for the largest possible value val that we can make the minimum value of gameScore across all indices.
Range : [1,10^18]
1 -> (minimum possible score)
10^18-> (a large value assuming the worst-case scenario)]
Try a middle value mid and check if it is possible to make every gameScore[i] at least mid using at most m moves.


How to check if chosen mid value will form the answer
For a given val, we check if it is possible to ensure every gameScore[i] is at least val within m moves.
Steps:
1. Iterate through the array (points[i] represents the score we can add at index i).
2. Calculate how many times index i must be visited to ensure gameScore[i] >= midVal. This is determined by:
necessaryMoves = (midVal+points[I]-1)/points[I] which ensures that gameScore[i] reaches at least val.

If previous moves have given extra visits (stored in transfer), use them before consuming new moves.
Otherwise, compute additional required moves.
Ensure total <= allowedMoves



If mid is valid, update ans = mid and search for a larger mid (increase left).
Otherwise, search for a smaller mid (decrease right).


why necessaryMoves works?
necessaryMoves = (midVal+points[I]-1)/points[I]

We are solving for x in this equation 
  x X points[I] >= midVal

where:
* x is the number of times we add points[i] to gameScore[i]
* midVal is the target minimum score for gameScore[i]
* points[i] is the score we gain at index i per move

Rearrange ->

 x >= midVal / points[I]

Since x cannot be fraction, taking the ceiling of division:

x = (midVal + points[I] - 1 )/ points[I]
*/
//code
class Solution {
    public long maxScore(int[] points, int m) {
        int n = points.length;
        if (m < n) return 0;

        long left = 1, right = (long) 1e18, maxPossibleMinScore = 0;
        
        while (left <= right) {
            long targetScore = left + (right - left) / 2;
            if (canAchieve(points, n, m, targetScore)) {
                maxPossibleMinScore = targetScore;
                left = targetScore + 1;
            } else {
                right = targetScore - 1;
            }
        }
        
        return maxPossibleMinScore;
    }
    
    private boolean canAchieve(int[] points, int n, int m, long targetScore) {
        long movesUsed = 0, extraMoves = 0, skippedMoves = 0;
        
        for (int i = 0; i < n && movesUsed <= m; i++) {
            int currentPoints = points[i];
            long requiredMoves = (targetScore + currentPoints - 1) / currentPoints;
            
            if (extraMoves >= requiredMoves) {
                extraMoves = 0;
                skippedMoves++;
            } else {
                long transferredPoints = extraMoves * (long) currentPoints;
                long newMoves = ((targetScore - transferredPoints) + currentPoints - 1) / currentPoints;
                movesUsed += 2 * newMoves - 1;
                movesUsed += skippedMoves;
                
                extraMoves = Math.max(newMoves - 1, 0);
                skippedMoves = 0;
            }
        }
        
        return movesUsed <= m;
    }
}
