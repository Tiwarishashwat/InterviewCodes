class Solution {
    public int findMin(int[] nums) {
        
//       If No elements are present return -1
        if(nums.length==0) return -1;
//         If array is rotated N times then array remains sorted or if only one element is present 
        if(nums.length==1 || nums[0] < nums[nums.length-1]) return nums[0];
//         if two elements are present return minimum of the two
        if(nums.length==2) return Math.min(nums[0], nums[1]);
        
          int start = 0, end = nums.length-1;
//         binary search
        while(start<= end)
        {
            int mid = start + (end-start)/2;
//             found the element if mid element is less than mid-1 element
            if(mid>0 && nums[mid] < nums[mid-1]) return nums[mid];
//             if you are inside the sorted array then move towards the unsorted array
            else if(nums[mid] < nums[end]) end = mid-1;
//             if you are inside the unsorted array then move towards the last element of unsorted array
            else if(nums[mid] > nums[end]) start = mid+1;
            
        }
        return -1;
       
    }
}
