class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int rowCount[] = new int[n];
        int colCount[] = new int[m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    rowCount[i]++;
                    colCount[j]++;
                    count++;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    // remove unreachable servers
                    if(rowCount[i] == 1 && colCount[j]==1)
                    count--;
                }
            }
        }
        return count;
    }
}
