class Solution {
    public int numOfSubarrays(int[] arr) {
        int Mod=1000000007;
        int evenC=1;
        int oddC=0;
        int prefix=0;
        int res=0;
        for(int num : arr){
            prefix+=num;
            if(prefix%2==0){
                res += oddC;
                evenC++;
            }else{
                res += evenC;
                oddC++;
            }
            res = res % Mod;
        }
        return res;
    }
}
