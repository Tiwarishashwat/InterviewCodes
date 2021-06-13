class Solution 
{
    public int maxChunksToSorted(int[] arr) 
    {
        int[]right = new int[arr.length + 1];
        right[arr.length] = Integer.MAX_VALUE;
        for(int i = arr.length -1 ;i>=0 ;i--){
             right[i] = Math.min(right[i+1] , arr[i]);
        }
        int count =0 ;
        int min = Integer.MIN_VALUE;
        for(int i =0 ; i < arr.length ;i++){
             min = Math.max(min , arr[i]);

             if(min <= right[i+1]){
                 count++;
             }
        }
        return count;
    }
}





