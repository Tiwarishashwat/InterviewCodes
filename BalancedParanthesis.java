class Solution
{
    //Function to check if brackets are balanced or not.
    public static boolean opening(char ch)
    {
        switch(ch)
        {
        case '{':
            return true;
        case '(':
            return true;
        case '[':
            return true;
        }
        return false;
    }
    
    public static boolean Matches(char a, char b)
    {
        if(a=='{' && b=='}') return true;
        if(a=='(' && b==')') return true;
        if(a=='[' && b==']') return true;
        return false;
        
    }
    
    static boolean ispar(String x)
    {
        // add your code here
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<x.length();i++)
        {
            if(opening(x.charAt(i)))
            {
                stack.push(x.charAt(i));
            }
            else
            {
                if(stack.isEmpty()) return false;
                if(!Matches(stack.peek(),x.charAt(i))) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
