//User function Template for Java


 class pair  
{  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
} 


class Compute 
{
    static pair getMinMax(long a[], long n)  
    {
        long maxi = Long.MIN_VALUE;
        long mini = Long.MAX_VALUE;
        //Write your code here
        for(int i=0;i<(int)n;i++)
        {
            if(a[i]>maxi)
            maxi = a[i];
            if(a[i]<mini)
            mini = a[i];
        }
        return new pair(mini,maxi);
    }
}
