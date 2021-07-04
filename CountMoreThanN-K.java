class Solution 
{
    //Function to find all elements in array that appear more than n/k times.
    public int countOccurence(int[] arr, int n, int k) 
    {
        // your code here,return the answer
       int barrier = n/k;
       HashMap<Integer,Integer> map = new HashMap<>();
       int counter=0;
       for(int i=0;i<n;i++)
       {
           map.put(arr[i],map.getOrDefault(arr[i],0)+1);
       }
       
       for(Map.Entry<Integer,Integer> entry : map.entrySet())
       {
           if(entry.getValue()>barrier) counter++;
       }
       return counter;
    }
}
