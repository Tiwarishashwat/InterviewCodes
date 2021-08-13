class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        permute(nums,0,list);
        return list;       
    }
    public static void swap(int nums[],int x,int y)
    {
        int p = nums[x];
        nums[x] = nums[y];
        nums[y] = p;
    }
    public static void permute(int nums[],int index,List<List<Integer>> list)
    {
        if(index==nums.length-1)
        {
            List<Integer> l = new ArrayList<>();
            for(int i=0;i<nums.length;i++)
            {
                l.add(nums[i]);
            }
            list.add(l);
            return;
        }
        for(int i=index;i<nums.length;i++)
        {
            swap(nums,i,index);
            permute(nums,index+1,list);
            swap(nums,index,i);
        }
    }
}
