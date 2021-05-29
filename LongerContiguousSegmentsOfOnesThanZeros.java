class Solution {
    public boolean checkZeroOnes(String s) {
        int ones=0,twos=0;
        if(s.charAt(0)=='1') ones=1;
        else twos=1;
        int temp=1;
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)==s.charAt(i-1)) temp++;
            else temp=1;
            
            if(s.charAt(i)=='1')
            {
                ones = Math.max(ones,temp);
            }
            else
            {
                twos = Math.max(twos,temp);
            }
        }
        return (ones>twos);       
    }
}
