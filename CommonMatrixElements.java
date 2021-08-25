import java.util.*;
class CommonMatrixElements
{
  public static void main(String args[])
  {
    // Input
    int mat[][] =
   {
       {1, 2, 1, 4, 8},
       {8, 7, 8, 5, 1},
       {8, 7, 7, 3, 1},
       {8, 1, 2, 7, 9},
   };
   // Funtion call
   commonElements(mat,mat.length,mat[0].length);
  }
  public static void commonElements(int Mat[][], int r, int c)
  {
    // Map
    HashMap<Integer,Integer> map = new HashMap<>();

    for(int i=0;i<c;i++)
    {
      map.put(Mat[0][i],1);
    }

      for(int i=1;i<r;i++)
      {
        for(int j=0;j<c;j++)
        {
          // Store and avoid duplicate elements of same row
          if(map.containsKey(Mat[i][j]) && map.get(Mat[i][j])==i)
          {
            map.put(Mat[i][j],map.get(Mat[i][j])+1);
          }

          if(i==r-1 && map.containsKey(Mat[i][j]) && map.get(Mat[i][j])==r)
          {
            System.out.print(Mat[i][j]+" ");
          }
        }
      }

  }
}
// second approach (without data structure)
import java.util.*;
class Maincodes
{
  public static void main(String args[])
  {
    // Input
    int mat[][] =
   {
       {1, 2, 1, 4, 8},
       {8, 7, 8, 5, 1},
       {8, 7, 7, 3, 1},
       {8, 1, 1, 7, 9},
   };
   // Funtion call
   commonElements(mat,mat.length,mat[0].length);
  }
  // function to check if there is any duplicate elements in the firstRow
  public static boolean seen(int arr[],int element,int end)
  {
    for(int i=0;i<end;i++)
    {
      if(element==arr[i]) return true;
    }
    return false;
  }
  public static void commonElements(int Mat[][], int r, int c)
  {
    // pick one by one element of the first row and check if they are present in all rows.
    for(int firstRow=0;firstRow<c;firstRow++)
    {
      // pick element
      int element=Mat[0][firstRow];
      // if duplicate then skip the element
      if(seen(Mat[0],element,firstRow)) continue;
      // variable for tracking rows.
      int count=0;
      // if element is not present in anyone of the row then skip the element.
      int flag=0;
      // traverse from 1st to last row
      for(int row=1;row<r;row++)
      {
        for(int col=0;col<c;col++)
        {
          // if element is found then increment the counter
          if(element==Mat[row][col])
          {
            count++;
            // if present in last row and count is equal to row-1, then print it
            if(row==r-1 && count==r-1)
              System.out.println(element);
              // if count is same as row then break to avoid adding duplicates
            else if(row!=r-1 && count==row)
              break;
              // if element not present in the current row then set flag to 1,
            else
            {
              flag=1;
              break;
            }
          }
        }
        // break the outer loop and check for next element.
        if(flag==1) break;
      }
    }
  }
}
