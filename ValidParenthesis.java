class Solution {
    
    public boolean isOpen(char ch)
    {
        switch(ch)
        {
        case '(':
                return true;
         case '{':
                return true;
         case '[':
                return true;
        }
        return false;
    }
    
    public boolean isSame(char str, char stk)
    {
        if(isOpen(stk))
        {
            if(str=='}' && stk=='{') return true;
            else if(str==')' && stk=='(') return true;
            else if(str==']' && stk=='[') return true;
        }
        return false;
    }
    
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if(isOpen(s.charAt(i))) stack.push(s.charAt(i));
            else
            {
                if(stack.isEmpty()) return false;
            
                if(isOpen(stack.peek()) && isSame(s.charAt(i),stack.peek()))
                {
                    stack.pop();
                }
                else return false;
            }
        }
        return (stack.isEmpty());
    }
}
