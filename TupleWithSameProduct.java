class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> productMap = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int res = nums[i] * nums[j]; 
                productMap.put(res, productMap.getOrDefault(res,0)+1);
            }   
        }
        int ans=0;
        for(Map.Entry<Integer, Integer> entry : productMap.entrySet()){
            int product = entry.getKey();
            int count = entry.getValue();
            if(count>=2){
                int comb = (count * (count-1))/2;
                ans = ans + comb*8;
            }
        }
        return ans;
    }
}
