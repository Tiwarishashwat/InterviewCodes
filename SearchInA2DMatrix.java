class Solution {
    public static boolean binSearch(int matrix[],int target)
    {
        int start=0,end=matrix.length-1;
        while(start<=end)
        {
            int mid = start+(end-start)/2;
            if(matrix[mid]==target)
                return true;
            else if(target<matrix[mid])
            {
                end=mid-1;
            }
            else
                start=mid+1;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        
//         Find the appropriate row
        int n=matrix.length;
        int m=matrix[0].length;
        boolean result=false;
        for(int i=0;i<n;i++)
        {
            if(target>=matrix[i][0] && target<=matrix[i][m-1])
            {
                result=binSearch(matrix[i],target);
            }
        }
        return result;
    }
}
