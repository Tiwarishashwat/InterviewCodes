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
