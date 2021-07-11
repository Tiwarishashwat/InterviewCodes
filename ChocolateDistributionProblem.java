class Solution
{
    public long findMinDiff (ArrayList<Long> a, long n, long m)
    {
        // your code here
        Collections.sort(a);
        long minDiff = Long.MAX_VALUE;
        for(int i=0;i+m-1<n;i++)
        {
            minDiff = Math.min(a.get(i+(int)m-1)-a.get(i),minDiff);
        }
        return minDiff;
    }
}
