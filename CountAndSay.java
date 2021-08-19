class Solution {
    public String countAndSay(int n) {
        
        if(n==1) return "1";
//         Recursion
        String s=countAndSay(n-1);
        StringBuilder res = new StringBuilder();
        // String res="";
        int counter=0;
        
        for(int i=0;i<s.length();i++)
        {
            counter++;
//             Segregating into groups
            if(i==s.length()-1 || s.charAt(i)!=s.charAt(i+1))
            {
                res.append(counter).append(s.charAt(i));
                // res=res+counter+s.charAt(i);
                counter=0;
            }
        }
          return res.toString();
       
        
    }
}
