// findKthBit - recursion
class Solution {
    public char findKthBit(int n, int k) {
        int len = (int)Math.pow(2,n) - 1;
        return recur(len,k);
    }
    public char recur(int len, int k){
        //base case
        if(len == 1){
            return '0';
        }
        int half = len/2;
        int middle = half+1;
        System.out.println("len -> "+ len + " ,middle-> " + middle + " ,k-> "+ k);
        if(k==middle){
            return '1';
        }else if(k<middle){ //left
            return recur(half,k);
        }else { //right
            char ans = recur(half, 1 + len - k);
            return (ans == '0')?'1':'0';
        }
    }
}
