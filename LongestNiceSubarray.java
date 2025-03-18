class Solution {
    public int longestNiceSubarray(int[] nums) {
        int start=0;
        int maxLen=0;
        int bitMask=0;
        int n = nums.length;
        for(int end=0;end<n;end++){
            //shrinking 
            while((bitMask & nums[end]) != 0){
                bitMask = bitMask ^ nums[start];
                start++;
            }
            bitMask = bitMask | nums[end];
            maxLen = Math.max(maxLen, end - start +1);
        }
        return maxLen;
    }
}
