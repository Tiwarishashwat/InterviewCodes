//User function Template for Java

class Solution {
    int median(int matrix[][], int r, int c) {
        // code here   
        
        int startVal=0,endVal=2000,midVal;
        int n=r*c;
        while(startVal<=endVal)
        {
            midVal=(endVal+startVal)/2;
            int ans=0;
            for(int i=0;i<r;i++)
            {
                int l=0,h=c-1;
                while(l<=h)
                {
                    int m=l+(h-l)/2;
                    if(matrix[i][m]<=midVal) l=m+1;
                    else h=m-1;
                }
                ans+=l;
            }
            if(ans<=n/2) startVal=midVal+1;
            else endVal=midVal-1;
        }
        return startVal;
    }
}
