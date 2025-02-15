//plain recursion
class Solution {
    public boolean isPartition(int j, String i2, int i, int curSum){
        int n = i2.length();
        // base case
        if(j == n){
            return (curSum == i);
        }
        for(int index=j;index<n;index++){
            int val = Integer.parseInt(i2.substring(j,index+1));
            if(isPartition(index+1,i2,i,curSum+val)){
                return true;
            }
        }
        return false;
    }
    public int punishmentNumber(int n) {
        int res=0;
        for(int i=1;i<=n;i++){
            String i2 = Integer.toString(i*i);
            if(isPartition(0,i2,i,0)){
                res += (i*i);
            }
        }
        return res;
    }
}

//pruning
class Solution {
    public boolean isPartition(int j, String i2, int i, int curSum){
        int n = i2.length();
        // base case
        if(j == n){
            return (curSum == i);
        }
        if(curSum > i){
            return false;
        }
        for(int index=j;index<n;index++){
            int val = Integer.parseInt(i2.substring(j,index+1));
            if(isPartition(index+1,i2,i,curSum+val)){
                return true;
            }
        }
        return false;
    }
    public int punishmentNumber(int n) {
        int res=0;
        for(int i=1;i<=n;i++){
            String i2 = Integer.toString(i*i);
            if(isPartition(0,i2,i,0)){
                res += (i*i);
            }
        }
        return res;
    }
}

//dp
class Solution {
    public boolean isPartition(int j, String i2, int i, int curSum, int dp[][]){
        int n = i2.length();
        // base case
        if(j == n){
            return (curSum == i);
        }
        if(curSum > i){
            return false;
        }
        if(dp[j][curSum]!=-1){
            return (dp[j][curSum] == 1);
        }
        for(int index=j;index<n;index++){
            int val = Integer.parseInt(i2.substring(j,index+1));
            if(isPartition(index+1,i2,i,curSum+val,dp)){
                dp[j][curSum] =1;
                return true;
            }
        }
        dp[j][curSum] =0;
        return false;
    }
    public int punishmentNumber(int n) {
        int res=0;
        for(int i=1;i<=n;i++){
            String i2 = Integer.toString(i*i);
            int len = i2.length();
            int dp[][] = new int[len][i+1];
            for(int k=0;k<len;k++){
                Arrays.fill(dp[k],-1);
            }
            if(isPartition(0,i2,i,0,dp)){
                res += (i*i);
            }
        }
        return res;
    }
}
