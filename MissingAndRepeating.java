class Solve 
{
    int[] findTwoElement(int arr[], int n) 
    {
        // code here
        int result[] = new int[2];
        
        int sum=0;
        
        int origSum=0;
        
        for(int i=0;i<n;i++)
        {
            int index = Math.abs(arr[i])-1;
            
            if(arr[index]<0)
            {
                result[0] = Math.abs(arr[i]);
            }
            
            arr[index] = -arr[index];
            
            sum+=Math.abs(arr[i]);
            
            origSum+=(i+1);
        }
        result[1]=origSum-(sum-result[0]);
        
        return result;
    }
}
