// Approach 1: Recursion!
class Solution {
    public String countAndSay(int n) {
         if(n==1) return "1";
        String s=countAndSay(n-1);
        String res="";
        int count=1,flag=0;
        for(int i=0;i<s.length()-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1))
            {
                count++;
                flag=i+1;
            }
            else{
                res=res+count+""+s.charAt(i);
                count=1;
            }
        }
        if(flag+1==s.length()){
            res=res+count+""+s.charAt(flag);
        }
        else
        {
            res=res+"1"+s.charAt(s.length()-1);
        }
        return res;               
    }

}
