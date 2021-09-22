class Solution
{
    String secFrequent(String arr[], int N)
    {
        // your code here
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int i=0;i<N;i++)
        {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        
        int first_max = Integer.MIN_VALUE, sec_max = Integer.MIN_VALUE;
        
        Iterator<Map.Entry<String, Integer>> itr = map.entrySet().iterator();
    
       while (itr.hasNext())
       {
           Map.Entry<String, Integer> entry = itr.next();
           int v = entry.getValue();
           if( v > first_max) 
           {
                sec_max = first_max;
                first_max = v;
            }
            else if (v > sec_max && v != first_max)
                sec_max = v;
       }
       
       itr = map.entrySet().iterator();
       
       while (itr.hasNext())
       {
           Map.Entry<String, Integer> entry = itr.next();
           int v = entry.getValue();
           if (v == sec_max)
                return entry.getKey();
       }
       return null;
    }
}
