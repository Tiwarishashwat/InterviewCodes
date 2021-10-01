class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int index=0,tank=0,total=0;
        for(int i=0;i<gas.length;i++)
        {
         int consume=gas[i]-cost[i];
            tank+=consume;
            if(tank<0)
            {
                index=i+1;
                tank=0;
            }
            total+=consume;
        }
        return (total<0)?-1:(index);
    }
}
    
  
