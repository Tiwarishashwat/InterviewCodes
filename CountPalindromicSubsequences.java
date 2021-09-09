class Solution
{
    long countPS(String str)
    {
        // Your code here
        
        return recursion(str,0,str.length()-1);
        
    }
    public static long recursion(String str,int start,int end)
    {
        // base case
        if(start>=str.length() || end<0) return 0;
        // single element is always palindrome
       if(start==end) return 1;
    //   check twice and subtract
       else if (str.charAt(start) == str.charAt(end))
        return   recursion(str,start+1, end) + recursion(str,start, end-1) + 1;
        
        else 
        return recursion(str,start+1, end) + recursion(str,start, end-1) - recursion(str,start+1, end-1);
        
    }
    
}
