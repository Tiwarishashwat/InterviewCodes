class Solution {
    public String fractionAddition(String expression) {
        int num=0;
        int den=1;
        int n = expression.length();
        int i=0;
        while(i<n){
            int curNum=0;
            int curDen=0;
            boolean isNeg = false;
            char ch = expression.charAt(i);
            if(ch == '+' || ch == '-'){
                if(ch=='-'){
                    isNeg = true;
                }
                i++;
            }
            //form the num
            int start=i;
            while(Character.isDigit(expression.charAt(i))){
                i++;
            }
            curNum = Integer.parseInt(expression.substring(start,i));
            if(isNeg) curNum*=-1;
            i++; //skip /
            //form the den
            start=i;
            while(i<n && Character.isDigit(expression.charAt(i))){
                i++;
            }
            curDen = Integer.parseInt(expression.substring(start,i));
            num = num * curDen + curNum * den;
            den *= curDen;
        }
        int gcd = Math.abs(getGCD(num,den));
        num/=gcd;
        den/=gcd;
        return num + "/" + den;
    }
    public int getGCD(int a, int b){
        if(a==0) return b;
        return getGCD(b%a,a);
    }
}
