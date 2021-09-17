class Solution {
    public int minAddToMakeValid(String s) {
        
        int open=0,close=0;
//         look only for invalid pairs
        
        for(int i=0;i<s.length();i++)
        {
            // open the brackets whenever possible
            if(s.charAt(i)=='(') open++;
            else
            {
                // if its not possible to make a pair then add the closing ones
                if(open==0) close++;
                // closing the earlier opened brackets
                else open--;
            }
        }
        // for making each invalid bracket a valid one, we need to include its opposite one
        return(open+close);
        
        
    }
}
