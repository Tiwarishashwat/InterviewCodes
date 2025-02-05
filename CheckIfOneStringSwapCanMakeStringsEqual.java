class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int count=0;
        int i=0;
        int j=0;
        int n = s1.length();
        for(int p=0;p<n;p++){
            if(s1.charAt(p)!=s2.charAt(p)){
                count++;
                if(count>2) return false;
                else{
                    if(count == 1) i=p;
                    else j=p;
                }
            }
        }
        return (s1.charAt(i) == s2.charAt(j)
        && s2.charAt(i) == s1.charAt(j));
    }
}
