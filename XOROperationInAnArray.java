class Solution {
    public int xorOperation(int n, int start) {
        
        int res=start;
        for(int i=0;i<n-1;i++)
        {
            int x=(res | (start + 2*(i+1)));
            int y=(~res | ~(start + 2*(i+1)));
            res = (x&y);
        }
        return res;        
    }
}
