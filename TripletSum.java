class Solution
{
    //Function to find if there exists a triplet in the 
    //array A[] which sums up to X.
    public static boolean find3Numbers(int A[], int n, int X) { 
    
       // Your code 
     for(int i=0;i<n-2;i++)
     {
         HashSet<Integer> set = new HashSet<>();
         int toFind=X-A[i];
         for(int j=i+1;j<n;j++)
         {
             if(set.contains(toFind-A[j]))
             {
                 return true;
             }
             set.add(A[j]);
         }
     }
     return false;
    }
}
