class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int lCount=0;
        int gCount=0;
        int pCount=0;
        for(int num : nums){
            if(num < pivot){
                lCount++;
            }else if(num > pivot){
                gCount++;
            }else{
                pCount++;
            }
        }
        int i=0;
        int j=lCount;
        int k=lCount + pCount;
        int res[] = new int[nums.length];
        for(int num : nums){
            if(num < pivot){
                res[i] = num;
                i++;
            }else if(num > pivot){
                res[k] = num;
                k++;
            }else{
                res[j] = num;
                j++;
            }
        }
        return res;
    }
}
