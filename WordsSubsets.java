class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int freq[] = new int[26];
        for(String word : words2){ //M
            int temp[] = getFreq(word); //p
            for(int i=0;i<26;i++){ //26
                freq[i] = Math.max(freq[i], temp[i]);
            }
        }
        List<String> res = new ArrayList<>();
        for(String word : words1){ //n
            int temp[] = getFreq(word); //p
            boolean flag=true;
            for(int i=0;i<26;i++){ //26
                if(freq[i] > temp[i]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                res.add(word);
            }
        }
        return res;
    }
    public int[] getFreq(String word){
        int freq[] = new int[26];
        for(int i=0;i<word.length();i++){
            freq[word.charAt(i) - 'a']++;
        }
        return freq;
    }
}
