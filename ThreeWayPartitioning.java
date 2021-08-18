class Solution{
    //Function to partition the array around the range such 
    //that array is divided into three parts.
     public static void swap(int arr[], int a, int b)
    {
        int x=arr[a];
        arr[a]=arr[b];
        arr[b]=x;
    }
    public void threeWayPartition(int array[], int a, int b)
    {
        // code here 
         int l = 0;
        int r = array.length-1;
        int i=0;
        for(i=0;i<=r;i++)
        {
            if(array[i]<a)
            {
                swap(array,l,i);
                l++;
            }
            else if(array[i]>b)
            {
                swap(array,r,i);
                r--;
                i--;
            }
        }
    }
}
