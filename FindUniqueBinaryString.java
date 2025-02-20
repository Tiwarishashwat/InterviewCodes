//O(2^N)

class Solution {
    StringBuilder res;
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        HashSet<String> set = new HashSet<>();
        for(String num : nums){
            set.add(num);
        }
        res=new StringBuilder("");
        backtrack(nums,n,set,res);
        return res.toString();
    }
    public boolean backtrack(String nums[], int n,HashSet<String> set, StringBuilder res){
        //base case
        if(res.length() == n){
            if(!set.contains(res.toString())){
                return true;
            }
            return false;
        }
        for(char ch='0';ch<='1';ch++){
            res.append(ch);
            if(backtrack(nums,n,set,res)){
                return true;
            }
            res.deleteCharAt(res.length()-1);
        }
        return false;
    }
}


//O(N)
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        StringBuilder res = new StringBuilder("");
        for(int i=0;i<n;i++){
            char ch = (nums[i].charAt(i)=='0'?'1':'0');
            res.append(ch);
        }
        return res.toString();
        
    }
}
