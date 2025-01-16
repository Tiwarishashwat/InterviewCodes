class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        // n + m
        int n = nums1.length;
        int res=0;
        if(n%2!=0){
            for(int num : nums2){
                res^=num;
            }
        }
        int m = nums2.length;
        if(m%2!=0){
            for(int num : nums1){
                res^=num;
            }
        }
        return res;
    }
}
