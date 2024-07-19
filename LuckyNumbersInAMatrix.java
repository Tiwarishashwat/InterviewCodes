class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxOfRowMins=Integer.MIN_VALUE;
        for(int i=0;i<rows;i++){
            int minVal = matrix[i][0];
            for(int j=0;j<cols;j++){
                minVal = Math.min(minVal,matrix[i][j]);
            }
            maxOfRowMins = Math.max(minVal,maxOfRowMins);
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<cols;i++){ //cols
            int maxVal = matrix[0][i];
            for(int j=0;j<rows;j++){ //rows
                maxVal = Math.max(maxVal,matrix[j][i]);
            }
            if(maxVal == maxOfRowMins){
                res.add(maxVal);
            }
        }
        return res;
    }
}
