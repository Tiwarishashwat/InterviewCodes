class Solution {
    public int maxProfit(int[] prices) {
        
        int n=prices.length;
        int left[] = new int[n];
        int right[]= new int[n];
        int lmin=prices[0],rmax=prices[n-1];
//         First purchase
        
        for(int i=1;i<n;i++)
        {
            left[i] = Math.max(left[i-1],prices[i]-lmin);
            lmin=Math.min(lmin,prices[i]);
        }
//         Second purchase
         for(int i=n-2;i>=0;i--)
        {
            right[i] = Math.max(right[i+1],rmax-prices[i]);
            rmax=Math.max(rmax,prices[i]);
        }
        
        int profit=right[0];
        
        for(int i=1;i<n;i++)
        {
            profit=Math.max(profit,left[i-1]+right[i]);
        }
        return profit;
          
      
    }
}
