class Solution{
    
    // temp: input array
    // n: size of array
    //Function to rearrange  the array elements alternately.
    public static void rearrange(int arr[], int n){
        
        // Your code here
        int j=0,k=n-1;
        int key=arr[n-1]+1;
        for(int i=0;i<n;i++)
        {
            // even should be max
            if(i%2==0)
            {
                arr[i]=((arr[k]%key)*key)+arr[i];
                k--;
            }
            // odd should be min
            else
            {
                arr[i] = ((arr[j]%key)*key)+arr[i];
                j++;
            }
        }
        
        for(int i=0;i<n;i++)
        {
            arr[i]/=key;
        }

    }
    
}
