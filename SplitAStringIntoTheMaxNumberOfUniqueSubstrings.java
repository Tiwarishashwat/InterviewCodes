class Solution {
    int maxCount;
    public int maxUniqueSplit(String s) {
        maxCount=0;
        HashSet<String>set = new HashSet<>();
        backtrack(s,set,0);
        return maxCount;
    }
    // tc: n * 2^n
    // sc: n substring
    public void backtrack(String s, HashSet<String> set, int index){
        //base case
        int n = s.length();
        if(index==n){
            maxCount = Math.max(maxCount,set.size());
            return;
        }
        //loop
        for(int i=index;i<n;i++){
            //check if substring is present in set or not
            String sub = s.substring(index,i+1);
            if(!set.contains(sub)){
                set.add(sub);
                backtrack(s,set,i+1);
                set.remove(sub);
            }
        }
    }
    
}
