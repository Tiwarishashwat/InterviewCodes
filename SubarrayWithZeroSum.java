class Solution{
    //Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[],int n)
    {
        // declare a set data structure
        HashSet<Integer> res = new HashSet<>();
        // Variable to calculate sum
        int sum=0;
        // Traversing the array
        for(int i=0;i<n;i++)
        {
            res.add(sum);
            sum+=arr[i];
            if(res.contains(sum))
            {
                return true;
            }
        }
        return false;
    }
}
