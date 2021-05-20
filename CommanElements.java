class Solution
{
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
        // code here 
        // Declare an Array list to store results
        ArrayList<Integer> arr = new ArrayList<>();
        int i=0,j=0,k=0;
        while(i<n1 && j<n2 && k<n3)
        {
            if(A[i]<B[j]) i++;
            else if(A[i]>B[j]) j++;
            else
            {
                // This is for checking duplicacy
                if(i>0 && A[i]==A[i-1])
                {
                    i++;
                    continue;
                }
                // Now we will search the common element in third array!
                // k<n3 avoids array index out of bound exception
                while(k<n3 && C[k]<B[j]) k++;
                if(k<n3 && C[k]==B[j])
                {
                    arr.add(C[k]);
                }
                i++;j++;
            }
        }
        return arr;
    }
}
