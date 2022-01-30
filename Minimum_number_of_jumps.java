class Solution{
    static int minJumps(int[] arr){
        // your code here
        if(arr.length==1)
            return 0;
            
        if(arr[0]==0)
            return -1;
        
        int jump=0,halt=0;
        int maxDist=Integer.MIN_VALUE;
        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i]+i>=maxDist)
                maxDist=arr[i]+i;
            
            if(i==halt)
            {
                halt=maxDist;
                jump++;
                if(halt>=arr.length-1)
                    break;
            }
        }
        return (halt>=arr.length-1)?jump:-1;
    }
}
