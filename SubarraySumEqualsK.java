class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int sum=0,r=0;
        
        map.put(0,1); // key is 0 and value is 1
        
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            
            if(map.containsKey(sum-k))
            {
                r=r+map.get(sum-k);
            }
           map.put(sum,map.getOrDefault(sum,0)+1);
            // if(!map.containsKey(sum))
            // {
            //     map.put(sum,0);
            // }
            // map.put(sum,map.get(sum)+1);
        }
      return r;
    }
}
 
