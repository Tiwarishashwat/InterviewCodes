class Solution {
    public boolean isValid(int cap,int weights[],int days,int n)
    {
        int numDays=0;
        int sumOfWeights=0;
        for(int i=0;i<n;i++)
        {
           if(weights[i]>cap) return false;
            sumOfWeights+=weights[i];
            if(sumOfWeights>cap)
            {
                numDays++;
                sumOfWeights=weights[i];
            }
        }
        numDays++;
        return numDays<=days;
    }
    public int shipWithinDays(int[] weights, int days) {
        
        int minCap=Integer.MIN_VALUE;
        int maxCap=0;
        for(int i=0;i<weights.length;i++)
        {
            minCap=Math.max(minCap,weights[i]);
            maxCap+=weights[i];
        }
        int capacity=0;
        while(minCap<=maxCap)
        {
            int mid=(minCap+maxCap)/2;
            if(isValid(mid,weights,days,weights.length))
            {
                capacity=mid;
                maxCap=mid-1;
            }
            else
            {
                minCap=mid+1;
            }
        }
        return capacity;
    }
}
