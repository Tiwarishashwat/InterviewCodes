class Solution {
    public int minimumLength(String s) {
        // N + 26
        int freq[] = new int[26];
        int n = s.length();
        for(int i=0;i<n;i++){
            freq[s.charAt(i) - 'a']++;
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                if(freq[i]%2==0){
                    count+=2;
                }else{
                    count+=1;
                }
            }
        }
        return count;
    }
}
