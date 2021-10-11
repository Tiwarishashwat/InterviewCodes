class Solution {
    public int majorityElement(int[] nums) {
        
        int majority = 0;
        int candidate = 0;
        for(int num : nums)
        {
            if(majority == 0)
            {
                majority = 1;
                candidate = num;
            }
            else
            {
              if(num == candidate) majority += 1;
              else majority -= 1;   
            } 
        }
        return candidate;
    }
}
