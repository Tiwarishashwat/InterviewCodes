class Solution {
    public int countMaxOrSubsets(int[] nums) {
        //target or
        int targetOr=0;
        for(int num : nums){
            targetOr |= num;
        }
        //state: index,targetOr = 7
        Integer dp[][] = new Integer[nums.length][targetOr+1];
        return recur(0,nums,0,targetOr,dp);
    }
    // tc: n*targetOr
    // sc: n*targetOr
    public int recur(int index, int nums[], int curOr, int targetOr,Integer dp[][]){
        //base case
        if(index == nums.length){
            return (curOr == targetOr)?1:0;
        }
        //check if already solved
        if(dp[index][curOr]!=null){
            return dp[index][curOr];
        }
        // O(2^n)
        //pick
        int pickCount = recur(index+1, nums, curOr | nums[index], targetOr,dp);
        //no pick
        int noPickCount = recur(index+1, nums, curOr, targetOr,dp);
        return dp[index][curOr] = pickCount + noPickCount;
    }
}
