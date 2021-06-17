class Solution{
    
    // temp: input array
    // n: size of array
    //Function to rearrange  the array elements alternately.
    public static void rearrange(int arr[], int n){
    // Your code here
    int mini=0;
    int maxi=n-1;
    int val=arr[n-1]+1;
    for(int i=0;i<n;i++)
    {
      if(i%2==0)
      {
          arr[i]=val*(arr[maxi]%val)+arr[i];
          maxi--;
      }
      else
      {
          arr[i]=val*(arr[mini]%val)+arr[i];
          mini++;
      }
    }
    for(int i=0;i<n;i++)
    {
        arr[i]=arr[i]/val;
    }
    
    }
}
