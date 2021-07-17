//geeks for geeks solution
class Solution {

    public static int sb(int a[], int n, int x) {
        // Your code goes here 
        
        int start=0,end=1;
        int result=Integer.MAX_VALUE;
        int sum=a[start];
        if(sum>x) return 1;
        if(end<n) sum+=a[end];
        
        while(start<n && end<n)
        {
            if(sum>x)
            {
                result = Math.min(result,end-start+1);
                sum-=a[start];
                start++;
            }
            else
            {
                end++;
                if(end<n)
                {
                    sum+=a[end];
                }
            }
        }
        return result;
    }
}

//Leetcode solution

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start=0,end=1;
        int sum=nums[start];
        if(sum >= target) return 1;
        int n = nums.length;
        int result = Integer.MAX_VALUE;
        if(end<nums.length) sum+=nums[end];
        while(start<n && end<n)
        {
            if(sum>=target)
            {
               result=Math.min(result,end-start+1);
               sum-=nums[start];
               start++;
            }
            else
            {
                end++; 
                if(end<n) sum+=nums[end];
            }
        }
        return (result == Integer.MAX_VALUE)?0:result;
    }
}
