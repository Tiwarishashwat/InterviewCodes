class Solution{

    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    long maxSubarraySum(int arr[], int n){
        
        // Your code here
        long maxSoFar=arr[0];
        long curSum=arr[0];
        
        for(int i=1;i<arr.length;i++)
        {
            curSum = Math.max(arr[i], curSum+arr[i]);
            maxSoFar = Math.max(maxSoFar, curSum);
        }
        
        return maxSoFar;
    }
}
