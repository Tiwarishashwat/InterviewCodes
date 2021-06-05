class Solution {
    public int sumOddLengthSubarrays(int[] arr) 
    {
     int l=arr.length;
        int sum=0;
        for(int i=0;i<l;i++)
        {
            sum+=(((i+1)*(l-i)+1)/2)*arr[i];
        }
    return sum;
    }    
}
