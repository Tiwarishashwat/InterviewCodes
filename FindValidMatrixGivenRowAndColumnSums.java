class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length;
        int cols = colSum.length;
        int r=0;
        int c=0;
        int resMatrix[][] = new int[rows][cols];
        while(r<rows && c<cols){
            int minVal = Math.min(rowSum[r],colSum[c]);
            resMatrix[r][c] = minVal;
            rowSum[r]-=minVal;
            colSum[c]-=minVal;
            if(rowSum[r]==0){
                r++;
            }else{
                c++;
            }
        }
        return resMatrix;
    }
}
