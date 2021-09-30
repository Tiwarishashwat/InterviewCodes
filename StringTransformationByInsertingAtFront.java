class Solution
{
    int transform (String A, String B)
    {
        // code here
        if(A.length()!=B.length()) return -1;
        int arr[] = new int[256];       
        for(int i=0;i<A.length();i++)
        {
            arr[A.charAt(i)]++;
            arr[B.charAt(i)]--;
        }
        
        for(int i=0;i<256;i++)
        {
            if(arr[i]!=0) return -1;
        }
        
        int res=0;
        int p1 = A.length()-1;
        int p2 = B.length()-1;
        
        while(p1>=0)
        {
            if(A.charAt(p1)!=B.charAt(p2))
            {
                res++;
            }
            else
            {
                p2--;
            }
            p1--;
        }
        return res;
    }
}
