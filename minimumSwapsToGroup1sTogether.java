class Solution {
    public int minSwaps(int[] nums) {
        //window size - count of 1
        int windowSize = 0;
        for(int num : nums){
            windowSize+=num;
        }
        //find zeros in first window
        int curZeros=0;
        for(int i=0;i<windowSize;i++){
            if(nums[i]==0){
                curZeros++;
            }
        }
        //solve for remaining window
        int minZeros = curZeros;
        int start=0;
        int end = windowSize-1;
        int n = nums.length;
        while(start<n){
            //if removed element was 0, decrement 0 counter
            if(nums[start]==0){
                curZeros--;
            }
            start++;
            // if included element is 0, increment 0 counter
            end++;
            if(nums[end%n]==0){
                curZeros++;
            }
            minZeros = Math.min(minZeros, curZeros);
        }
        return minZeros;
    }
}
