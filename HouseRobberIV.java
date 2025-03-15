class Solution {
    public int minCapability(int[] nums, int k) {
        int start=Integer.MAX_VALUE;
        int end=Integer.MIN_VALUE;
        for(int num : nums){
            if(num>end){
                end = num;
            }
            if(num < start){
                start = num;
            }
        }
        int ans=0;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(isRobberyPossible(mid, nums, k)){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
    public boolean isRobberyPossible(int capability, int nums[], int minHouses){
        int housesRobbed=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] <= capability){
                housesRobbed++;
                i++; //skip for adjacent condition
            }
            if(housesRobbed >= minHouses) return true;
        }
        return false;
    }
}








