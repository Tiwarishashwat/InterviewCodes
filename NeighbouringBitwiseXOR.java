class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int res=0;
        for(int val : derived){
            res = res ^ val; 
        }
        return (res == 0);
    }
}
