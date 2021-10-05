//User function Template for Java
class Solution{
    static int minimumNumberOfSwaps(String S){
        // code here
        int open=0;
        int close=0;
        int swap=0;
        int imbalance=0;
        for(int i=0;i<S.length();i++)
        {
            if(S.charAt(i)=='[')
            {
                open++;
                if(imbalance>0)
                {
                    swap+=imbalance;
                    imbalance--;
                }
            }
            else
            {
                close++;
                imbalance=close-open;
            }
        }
        return swap;
    }
}
