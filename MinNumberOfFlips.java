class Solution {
    public int minFlips(String S) {
        // Code here
        int flips=0;
        for(int i=0;i<S.length();i++)
        {
            if(i%2==0)
            {
                if(S.charAt(i)=='0') flips++;
            }
            
            else if(i%2!=0)
            {
                if(S.charAt(i)=='1') flips++;
            }
        }
        
        return Math.min(flips,S.length()-flips);
    }
}
