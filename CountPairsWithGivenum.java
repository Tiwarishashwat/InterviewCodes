class Solution 
{
    int getPairsCount(int[] arr, int n, int k) 
    {
        int counter=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int x=k-arr[i];
            if(map.containsKey(x))
            {
                counter=counter+map.get(x);
            }
            if(map.get(arr[i])==null)
            {
                map.put(arr[i],0);
            }
            map.put(arr[i],map.get(arr[i])+1);
        }
        return counter;
    }
}
