class Solution {
    public int maxArea(int[] height) 
    {
         int b1=0;
        int b2=height.length-1;
        int r=0;
        while(b1<b2)
        {
            int curMax=(b2-b1)*Math.min(height[b1],height[b2]);
            if(height[b1]<height[b2])
            {
                b1++;
            }
            else
            {
                b2--;
            }
            r=Math.max(r,curMax);
        }
        return r;
    }
}
