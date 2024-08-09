class Solution {
    public int findRowSum(int grid[][], int r, int c){
       boolean visited[] = new boolean[10];
       int sum=0;
       for(int i=0;i<3;i++){
        int rowSum=0;
        for(int j=0;j<3;j++){
            int val = grid[r+i][c+j];
            if(val==0 || val>=10 || visited[val]){
                return -1;
            }
            visited[val] = true;
            rowSum+=val;
        }
        if(i==0){
            sum = rowSum;
        }else{
            if(sum!=rowSum){
                return -1;
            }
        }
       }
       return sum;
    }

    public int findColSum(int grid[][], int r, int c){
       int sum=0;
       for(int j=0;j<3;j++){
        int colSum=0;
        for(int i=0;i<3;i++){
            int val = grid[r+i][c+j];
            colSum+=val;
        }
        if(j==0){
            sum = colSum;
        }else{
            if(sum!=colSum){
                return -1;
            }
        }
       }
       return sum;
    }

    public int diagonalSum(int grid[][], int r, int c){
        int sum1 = grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2];
        int sum2 = grid[r][c+2] + grid[r+1][c+1] + grid[r+2][c];
        if(sum1==sum2){
            return sum1;
        }
        return -1;
    }
    public boolean isMagicSquare(int grid[][], int r, int c){
        int rowSum = findRowSum(grid,r,c); //3*3
        if(rowSum==-1) return false;
        int colSum = findColSum(grid,r,c);//3*3
        if(colSum==-1) return false;
        int diagonalSum = diagonalSum(grid,r,c); //const
        if(diagonalSum==-1) return false;
        if(rowSum==colSum && rowSum==diagonalSum){
            return true;
        }
        return false;
    }
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count=0;
        // rows * cols * (2 [3*3])
        for(int i=0;i<rows-2;i++){
            for(int j=0;j<cols-2;j++){
                if(isMagicSquare(grid,i,j)){
                    count++;
                }
            }   
        }
        return count;
    }
}
