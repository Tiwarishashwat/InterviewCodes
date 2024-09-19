class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();
        List<Integer>[][] dp = new ArrayList[n][n];
        return recur(expression,0,n-1,dp);
    }
    //tc: o(N*2^N)
    //sc: o(N^2*2^N)
    public List<Integer> recur(String exp, int start, int end,List<Integer>[][] dp){
        List<Integer> res = new ArrayList<>();
        if(dp[start][end]!=null){
            return dp[start][end];
        }
        //base case : single digit
        if(start==end){
            int num = exp.charAt(start)-'0';
            res.add(num);
            return res;
        }
        //base case : double digit
        if(end-start==1 && Character.isDigit(exp.charAt(start))){
            int num1 = exp.charAt(start)-'0'; 
            int num2 = exp.charAt(end)-'0';
            // int num = Integer.parseInt(exp.substring(start,end+1));
            res.add(num1*10 + num2);
            return res;
        }
        //split
        // N
        for(int i=start;i<=end;i++){
            if(Character.isDigit(exp.charAt(i))){
                continue;
            }
            char op = exp.charAt(i);
            // 2^N
            List<Integer> left = recur(exp,start,i-1,dp);
            List<Integer> right = recur(exp,i+1,end,dp);
            for(int l : left){
                for(int r : right){
                    if(op == '*'){
                        res.add(l*r);
                    }else if(op == '+'){
                        res.add(l+r);
                    }else{
                        res.add(l-r);
                    }
                }
            }
        }
        dp[start][end] = res;
        return res;
    }
}
