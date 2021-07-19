class Complete{
    // Function for finding maximum and value pair
    public static int minSwap (int arr[], int n, int k) {
        //Complete the function
        
        int fav=0,nonFav=0;
        for(int i=0;i<n;i++)
        {
            if(arr[i]<=k) fav++;
        }
        
        for(int j=0;j<fav;j++)
        {
            if(arr[j]>k) nonFav++;
        }
        
        int l=0,r=fav-1, result = Integer.MAX_VALUE;
        
        while(r<n)
        {
            result = Math.min(result,nonFav);
            r++;
            if(r<n && arr[r]>k) nonFav++;
            if(l<n && arr[l]>k) nonFav--;
            l++;
        }
        
        return (result  == Integer.MAX_VALUE)?0:result;
        
    }
}
