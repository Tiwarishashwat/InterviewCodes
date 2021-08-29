class Solution {
    
    public boolean isCorrect(int mid,int nums[],int m,int n)
    {
        int sum=0;
        int noOfSubarrays=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]>mid) return false;
            sum+=nums[i];
            if(sum>mid)
            {
                // increment number of subarray
                noOfSubarrays++;
                // start a new subarray if required size is exceeded
                sum=nums[i];
            }
        }
        noOfSubarrays++;
        if(noOfSubarrays<=m) return true;
        return false;
    }
    
    public int splitArray(int[] nums, int m) {
        int start=Integer.MIN_VALUE,end=0;
        int n=nums.length;
        // calculate min and max of the range
        for(int i=0;i<n;i++)
        {
            start=Math.max(start,nums[i]);
            end+=nums[i];
        }
        int result=0;
        // apply binary search
        int mid=0;
        while(start<=end)
        {
            mid=(start+end)/2;
            if(isCorrect(mid,nums,m,n))
            {
                // store as result and check if we can further minimize it
                result=mid;
                end=mid-1;
            }
            else
            {
                start=mid+1;
            }
        }
        return result;
    }
}
