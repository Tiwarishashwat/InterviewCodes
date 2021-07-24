class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
    //   Declaraing an arrayList for storing the results
    ArrayList<Integer> spiralMat = new ArrayList<Integer>();
    // Declaring 4 pointers
    int startRow=0;
    int endRow=r-1;
    int startColumn=0;
    int endColumn=c-1;
    
    // Logic goes here
    
    while(startRow<=endRow && startColumn<=endColumn)
    {
            //from the starting row
        for(int i=startColumn;i<=endColumn;i++)
        {
            spiralMat.add(matrix[startRow][i]);
        }
        startRow++;
        
           //from the ending column
        for(int i=startRow;i<=endRow;i++)
        {
            spiralMat.add(matrix[i][endColumn]);
        }
        endColumn--;
        
        if(startRow<=endRow)
        {
               //from the ending row
        for(int i=endColumn;i>=startColumn;i--)
        {
            spiralMat.add(matrix[endRow][i]);
        }
        endRow--;
        }
        
         if(startColumn<=endColumn)
        {
               //from the starting Column
        for(int i=endRow;i>=startRow;i--)
        {
            spiralMat.add(matrix[i][startColumn]);
        }
        startColumn++;
        }
    }
    return spiralMat;
    }
}
