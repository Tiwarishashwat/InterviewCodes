//Hashing Solution
class Solution
{   
    // arr[] : the input array
    // N : size of the array arr[]
    
    //Function to return length of longest subsequence of consecutive integers.
	static int findLongestConseqSubseq(int arr[], int N)
	{
	   // add your code here
	   HashSet<Integer> set = new HashSet<Integer>();
	   for(int i=0;i<N;i++)
	   {
	       set.add(arr[i]);
	   }
	   int c=0;
	   for(int i=0;i<N;i++)
	   {
	       if(!set.contains(arr[i]-1))
	       {
	           int val = arr[i]+1;
	           while(set.contains(val)) val++;
	           c=Math.max(c,val-arr[i]);
	       }
	   }
	   return c;

	}
}

// Sorting solution
static int findLongestConseqSubseq(int arr[], int N)
	{
 int count=1,counter=1;
	   Arrays.sort(arr);
	   for(int i=1;i<N;i++)
	   {
	       if(arr[i]-arr[i-1]==1) count++;
	       else if(arr[i]-arr[i-1]!=0) count=1;
	       counter = Math.max(counter,count);
	   }
	   return counter;
}
