class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String,Integer> map = new HashMap<>();
        // N + M
        for(String word : s1.split(" ")){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        for(String word : s2.split(" ")){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        ArrayList<String> list = new ArrayList<>();
        // n+m
        for(Map.Entry<String,Integer> entry :map.entrySet()){
            if(entry.getValue()==1){
                list.add(entry.getKey());
            }
        }
        String res[] = new String[list.size()];
        // K
        list.toArray(res);
        return res;
    }
}
