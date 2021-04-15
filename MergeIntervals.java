class Solution {
    public int[][] merge(int[][] intervals) {
        // Sorting
        for(int i=0;i<intervals.length-1;i++)
        {
            int flag=0;
            for(int j=0;j<intervals.length-1;j++)
            {
                if(intervals[j][0]>intervals[j+1][0])
                {
                    //Swap
                    int temp[]=new int[2];
                    temp[0]=intervals[j][0];
                    temp[1]=intervals[j][1];
                    intervals[j][0]=intervals[j+1][0];
                    intervals[j][1]=intervals[j+1][1];
                    intervals[j+1][0]=temp[0];
                    intervals[j+1][1]=temp[1];
                    flag=1;
                }
            }
            if(flag==0)
            {
                break;
            }
        }
        List<int[]> res=new ArrayList<>();
        int current_interval[]=intervals[0];
        res.add(current_interval);
        for(int i=0;i<intervals.length;i++)
        {
            if(intervals[i][0]<=current_interval[1])
            {
                current_interval[1]=Math.max(current_interval[1],intervals[i][1]);
            }
            else
            {
                current_interval=intervals[i];
                res.add(current_interval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
