class Solution{
    //Function to partition the array around the range such 
    //that array is divided into three parts.
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
