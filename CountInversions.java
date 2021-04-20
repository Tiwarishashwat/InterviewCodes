class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        
        // Your Code Here
        return mergeSort(arr,0,N-1);
        
    }
    public static long mergeSort(long arr[],long s, long f)
    {
       long inv_count=0;
       if(s<f)
        {
            long mid=s+(f-s)/2;
            inv_count+=mergeSort(arr,s,mid); //left sub problem!
            inv_count+=mergeSort(arr,mid+1,f); //right ub problem!
            inv_count+=merge(arr,s,mid,f);
        }
        return inv_count;
    }
    
    public static long merge(long arr[],long s,long m, long e)
    {
        int n1=(int)(m-s+1);//5
        int n2=(int)(e-m);//5
        long L[]=new long[n1];
        long R[]=new long[n2];
        long count=0;
        // Creating a subarray!
        for(int i=0;i<n1;i++)
        {
            L[i]=arr[(int)(s)+i];
        }
        for(int j=0;j<n2;j++)
        {
            R[j]=arr[(int)(m)+1+j];
        }
        int i=0,j=0,k=(int)(s);
        while(i<n1 && j<n2)
        {
            if(L[i]<=R[j])
            {
                arr[k]=L[i];
                i++;
            }
            else
            {
                arr[k]=R[j];
                count+=n1-i;
                j++;
            }
            k++;
        }
        while(i<n1)
        {
            arr[k++]=L[i++];
        }
        while(j<n2)
        {
            arr[k++]=R[j++];
        }
        return count;
    }
}
