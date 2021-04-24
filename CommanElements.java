class Solution
{
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
        // code here 
        int i=0,j=0,k=0;
        ArrayList<Integer> res = new ArrayList<>();
        while(i<n1 && j<n2 && k<n3)
        {
            if(A[i]==B[j]) 
            {
                while(k<n3 && C[k]<A[i]) k++;
                if(k<n3 && A[i]==C[k])
                {
                    if(res.size()==0 || res.get(res.size()-1)!=A[i]) res.add(A[i]);
                    k++;
                }
                i++;
                j++;
            }
            else if(A[i]<B[j]) i++;
            else if(B[j]<A[i]) j++;
        }
        return res;
    }
}
