class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length(); 
        if(n < k) return false;
        if(n == k) return true;
        //find freq
        int count[] = new int[26];
        for(int i=0;i<n;i++){
            count[s.charAt(i) - 'a']++;
        }
        int c=0;
        //find odd count
        for(int i=0;i<26;i++){
            if((count[i]&1)==1) c++;
        }
        return (c<=k);
    }
}
