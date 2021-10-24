class Solution
{
	// Function to find the peak element
	// arr[]: input array
	// n: size of array a[]
	public int peakElement(int[] arr,int n)
    {
       //add code here.
      int lo=0;
      int hi=n-1;
      
      while(lo<=hi)
      {
        int mid = lo + (hi-lo)/2;
        
        if((mid == 0 || arr[mid]>=arr[mid-1]) && (mid==n-1 || arr[mid]>=arr[mid+1]))
        {
            return mid;
        }
        
        else if(mid>0 && arr[mid-1]>arr[mid])
        {
            hi=mid-1;
        }
        
        else
        {
            lo=mid+1;
        }
        
      }
      return 0;
    }
}
