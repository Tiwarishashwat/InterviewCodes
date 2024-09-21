//DFS
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<10;i++){
            if(i>n) break;
            dfs(i,n,res);
        }
        return res;
    }
    public void dfs(int curNum, int target, List<Integer>res){
        if(curNum>target){
            return;
        }
        res.add(curNum);
        for(int d=0;d<10;d++){
            if(curNum*10+d>target){
                break;
            }
            dfs(curNum*10+d,target,res);
        }
    }
}



//Iterative
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int curNum=1;
        for(int i=1;i<=n;i++){
            res.add(curNum);
            if(curNum*10 <= n){
                curNum*=10;
            }else{
                while(curNum%10 == 9 || curNum==n){
                    curNum/=10;
                }
                curNum+=1;
            }
        }
        return res;
    }
}
