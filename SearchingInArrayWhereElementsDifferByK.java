class Complete{
    
   
    // Function for finding maximum and value pair
    public static int search (int arr[], int n, int x, int k) {
        //Complete the function
        
        int index=0;
        
        while(index<n)
        {
            if(arr[index]==x) return index;
            
            int steps = Math.abs(arr[index]-x)/k;
            
            index= index + Math.max(1,steps);
        }
        
        return -1;
    }
}
