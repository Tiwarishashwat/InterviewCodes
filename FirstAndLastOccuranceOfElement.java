class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        // define array for storing output
        int arr[] = new int[2];
        // initialize with -1
        Arrays.fill(arr,-1);
        
        // border case
        if(nums==null || nums.length==0) return arr;
        arr[0] = search(nums,target,true);
        arr[1] = search(nums,target,false);
        return arr;
    }
    
    int search(int nums[],int target, boolean isFirst)
    {
        
          // utility variables for binary search
        int lo=0,hi=nums.length-1,mid=0;
        int index=-1;
        while(lo<=hi)
        {
            mid=lo+(hi-lo)/2;
           
            if(nums[mid]==target)
            {
                // for first
                 // if you see a number greater than or equal to target then move towards left
                if(isFirst)
                {
                    index=mid;
                    hi=mid-1;
                }
                // for second
                  // if you see a number less than or equal to target then move towards right
                else
                {
                    index=mid;
                    lo=mid+1;
                }
            }
            else if(nums[mid]>target) hi=mid-1;
            else lo=mid+1;
        }
        return index;
    }
}
