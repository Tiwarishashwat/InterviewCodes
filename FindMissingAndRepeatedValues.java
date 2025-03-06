class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int sq = n*n; 
        int set[] = new int[sq+1];
        // 1,sq
        int curSum=0;
        int ans[] = new int[2];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(set[grid[i][j]]!=0){
                    ans[0] = grid[i][j];
                }else{
                    set[grid[i][j]]=1;
                    curSum += grid[i][j];
                }
            }
        }
        int totalSum = sq * (sq+1)/2;
        ans[1] = totalSum - curSum;
        return ans;
    }
}
