//Stack Solution
class Solution {
    public int minSwaps(String s) {
       Stack<Character> stack = new Stack<Character>();
       int open=0,close=0;
       for(int i=0;i<s.length();i++){
           char ch = s.charAt(i);
           if(ch == '[') {
               stack.push(ch);
           } else {
               if(stack.isEmpty() || stack.peek() == ']' ){
                   stack.push(ch);
               } else {
                   stack.pop();
               }
           }
       }
       int totalBrackets = stack.size();
       int closedBrackets = totalBrackets/2;
       return (closedBrackets+1)/2; 
    }
}

//Convert Stack to two pointer
class Solution {
    public int minSwaps(String s) {
       Stack<Character> stack = new Stack<Character>();
       int open=0,close=0;
       for(int i=0;i<s.length();i++){
           char ch = s.charAt(i);
           if(ch == '[') {
               stack.push(ch);
           } else {
               if(stack.isEmpty() || stack.peek() == ']' ){
                   stack.push(ch);
               } else {
                   stack.pop();
               }
           }
       }
       int totalBrackets = stack.size();
       int closedBrackets = totalBrackets/2;
       return (closedBrackets+1)/2; 
    }
}
