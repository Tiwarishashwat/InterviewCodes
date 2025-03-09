class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int res=0;
        int left=0;
        int n = colors.length;
        // N+K
        for(int right=1;right < (n + k -1); right++){ // exp..
            // skip entire subarray
            if(colors[right%n] == colors[(right-1)%n]){
                left = right;
            }
            if(right - left + 1 == k){
                res++;
                left++; // move to next subarray or shrinking phase
            }
        }
        return res;
    }
}
