class Solution
{
    static boolean isMajority(int a[], int size, int candidate)
    {
        int counter=0;
        for(int i=0;i<size;i++)
        {
            if(a[i]==candidate)
            {
                counter++;
            }
        }
        return (counter>size/2);
    }
    static int majorityElement(int a[], int size)
    {
        // your code here
        
        int candidate=-1;
        int votes=0;
        for(int i=0;i<size;i++)
        {
            if(votes==0)
            {
                candidate=a[i];
                votes=1;
            }
            else
            {
                if(a[i]==candidate)
                    votes++;
                else
                    votes--;
            }
        }
        return (isMajority(a,size,candidate))?candidate:-1;
    }
}
