class SubrectangleQueries {

    int arr[][];
    List<int[]> temp;
    public SubrectangleQueries(int[][] rectangle) {
        arr=rectangle;
        temp = new ArrayList<>();
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
    temp.add(new int[]{row1,col1,row2,col2,newValue});    
    }
    
    public int getValue(int row, int col) {
        int result = arr[row][col];
        for(int a[]:temp)
        {
            if(row>=a[0] && row<=a[2] && col>=a[1] && col<=a[3])
            {
                result=a[4];
            }
        }
        return result;
    }
}
/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */
