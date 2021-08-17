// Efficient solution
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
// Brute Force Solution
class Solution 
{
    //Function to check if we have already seen an element or not.
    public boolean notInVisited(int visitedArray[],int element)
    {
        // Iterate the visitedArray
        for(int i=0;i<visitedArray.length;i++)
        {
            if(visitedArray[i] == element)
             return false;
        }
        return true;
    }
    
    public int countOccurence(int[] arr, int n, int k) 
    {
        // your code here,
        // return the answer
        
        // Array for storing visited elements
        int visitedArray[] = new int[n];
        int count, counter=0;
        int index=0;
        // traverse the array
        for(int i=0;i<n;i++)
        {
            // Initialize count to zero for all elements 
            count=0;
            // calculate frequency only if we are seeing this element for the first time
            if(notInVisited(visitedArray,arr[i]))
            {
                for(int j=i;j<n;j++)
                {
                    if(arr[i]==arr[j])
                    {
                        count++;
                    }
                }
                // Store element into visited array after calculating its frequency
                visitedArray[index]=arr[i];
                index++;
            }
            // If count is more than n/k then add it to the answer
            if(count>n/k)
            {
                counter++;                
            }
        }
        return counter;
    }
}
