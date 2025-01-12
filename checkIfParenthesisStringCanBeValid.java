class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if(n%2!=0) return false;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> unlocked = new Stack<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            char state = locked.charAt(i);
            if(state == '0'){
                unlocked.push(i);
            }else if(ch == '('){
                stack.push(i);
            }else{ // locked and closing
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    if(!unlocked.isEmpty()){
                        unlocked.pop();
                    }else{
                        return false;
                    }
                }
            }
        }

        while(!stack.isEmpty() && !unlocked.isEmpty() && stack.peek() < unlocked.peek()){
            stack.pop();
            unlocked.pop();
        }
        return (stack.isEmpty());
    }
}
