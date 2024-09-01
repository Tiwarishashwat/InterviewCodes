// matrix logic
class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n != original.length){
            return new int[0][0];
        } 
        int index=0;
        int res[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res[i][j] = original[index];
                index++;
            }
        }
        return res;
        
    }
}

// maths logic
class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n != original.length){
            return new int[0][0];
        } 
        int res[][] = new int[m][n];
        for(int i=0;i<original.length;i++){
            res[i/n][i%n] = original[i];
        }
        return res;
        
    }
}
