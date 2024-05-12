//TC -> (N-2)*(N-2)*(9log9 + 6log6)

class Solution {
  // this function will return remove the last column and add a new column example
  // if matrix is [A,B,C,X] then the first 3*3 matrix(starting at [0,0] cell) would be [A,B,C] and second 3*3 matrix(starting at 0,1 cell) would be [B,C,X]
  //              [D,E,F,Y]                                                            [D,E,F]                                                      [E,F,Y]
  //              [G,H,I,Z]                                                            [G,H,I]                                                      [H,I,Z]
  // so we can see that b/w these two matrix first column is removed and next column is added.
  // so we can maintain a priority queue and store first 9 elements, 
  // Hence for every 3*3 matrix starting at the ith row and jth column ([i,j] cell and j>0) remove the (j-1)th column, add the (j+2)th column and find the maximum
  // at every new row, reinitialize the queue.
    public int findMax(int[][] grid, int startRow, int startCol, PriorityQueue<Integer> pq){
        //for every new row, init the queue and store 9 elements (3*3)
      // TC -> O(9log9) [for inserting 1 element in pq, tc is logK, where k is number of element, our pq will always have 9 elements at max]
        if(startCol==0){
            pq.clear();
            for(int i=startRow;i<startRow+3;i++){
                for(int j=startCol;j<startCol+3;j++){
                    pq.offer(grid[i][j]);
                }
            }
        }else{ 
          //TC -> 6log9 [remove -> 3log9 + insert 3log9]
          //for same row, use sliding window to remove the (j-1)th column and add (j+2) column
            for(int j=startRow;j<startRow+3;j++){
                pq.remove(grid[j][startCol-1]);
                pq.offer(grid[j][startCol+2]);
            }
        }
        return pq.peek();
    }
    public int[][] largestLocal(int[][] grid) {
        //priorityQueue to return the maximum values out of 9 values (3*3 matrix)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int rows=grid.length;
        int cols=grid[0].length;
        int result[][] = new int[rows-2][cols-2];
        //ietrate the starting cells of all possible 3*3 matirx
        //TC-> (n-2 * n-2)
        for(int i=0;i<rows-2;i++){
            for(int j=0;j<cols-2;j++){
                //update the queue and return the max element
                result[i][j] = findMax(grid,i,j,pq);
            }
        }
        return result;
    }
}

//Note-> this is slower than the brute force approach but it can be helpful in finding the sum of all 3*3 matrix, i.e instead of a pq, use a prefix sum.

