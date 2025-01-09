class Solution {
    public int prefixCount(String[] words, String pref) {
        int count=0;
        int len = pref.length();
        for(String word : words){
            if(len <= word.length()){
                String sub = word.substring(0,len);
                if(pref.equals(sub)){
                    count++;
                }
            }
        }
        return count;
    }
}
