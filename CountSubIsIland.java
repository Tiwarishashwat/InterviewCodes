class Solution {
    int rows;
    int cols;
    int dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};
    public boolean dfs(int row, int col,int[][] grid1, int[][] grid2,
    boolean visited[][]){
        visited[row][col] = true;
        boolean isIsland = true;
        if(grid1[row][col]==0){
            isIsland = false;
        }
        //visiting neighbour cells;
        for(int dir[] : dirs){
            int nextR = row + dir[0];
            int nextC = col + dir[1];
            if(nextR>=0 && nextC>=0 && nextR<rows && nextC<cols && grid2[nextR][nextC]==1 && !visited[nextR][nextC]){
                boolean res = dfs(nextR,nextC,grid1,grid2,visited);
                isIsland = isIsland && res;
            }
        }
        return isIsland;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        rows = grid1.length;
        cols = grid1[0].length;
        boolean visited[][] = new boolean[rows][cols];
        int count=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(!visited[i][j] && grid2[i][j]==1){
                    if(dfs(i,j,grid1,grid2,visited)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
