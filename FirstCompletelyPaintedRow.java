class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length; //rows
        int m = mat[0].length; //cols
        int rowCount[] = new int[n];
        int colCount[] = new int[m];
        // num -> (r,c)
        HashMap<Integer,int[]> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map.put(mat[i][j], new int[]{i,j});
            }
        }
        int totalCells = n*m;
        for(int i=0;i<totalCells;i++){
            int cell[] = map.get(arr[i]);
            rowCount[cell[0]]++;
            colCount[cell[1]]++;
            if(rowCount[cell[0]] == m || colCount[cell[1]] == n){
                return i;
            }
        }
        return -1;
    }
}
