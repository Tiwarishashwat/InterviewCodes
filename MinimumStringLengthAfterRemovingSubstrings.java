//stack
class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(ch);
                continue;
            }
            if(ch == 'B' && stack.peek() == 'A'){
                stack.pop();
            }else if(ch == 'D' && stack.peek() == 'C'){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        return stack.size();
    }
}

//two pointers
class Solution {
    public int minLength(String s) {
        char str[] = s.toCharArray(); //N 
        int n = str.length;
        int w=0;
        for(int r=0;r<n;r++){ //N
            if(w==0){
                str[w] = str[r];
                w++;
                continue;
            }
            if(str[r] == 'B' && str[w-1]=='A'){
                w--;
            }else if(str[r] == 'D' && str[w-1]=='C'){
                w--;
            }else{
                str[w] = str[r];
                w++;
            } 
        }
        return w;
    }
}
