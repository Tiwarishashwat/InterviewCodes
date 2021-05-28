public class Main
{
	public static void main(String[] args) {
	   // int arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
	   // int arr[] = {1, 2, 3, -4, -1, 4};
	   int arr[] = {2,-8,-3,-5,-7,-1,-2};
	    int output[]=new int[arr.length];
	    output=rearrange(arr,arr.length);
	    print(output);
		
	}
	public static void print(int output[])
	{
	    for(int i=0;i<output.length;i++)
	    {
	        System.out.print(output[i]+" ");
	    }
	}
	public static void rotate(int nums[],int start, int end)
	{
	    int temp=nums[end];
	    for(int i=end-1;i>=start;i--)
	    {
	        nums[i+1]=nums[i];
	    }
	    nums[start]=temp;
	}
	public static int[] rearrange(int nums[], int n)
	{
	    int i=0,j=0,k=0;
	    while(k<n && i<n && j<n)
	    {
	        if(k%2==0)
	        {
	            if(nums[k]>=0)
	            {
	                i=k;
	                j=k;
	                while(i<n && nums[i]>=0) i++;
	                if(i>=n) break;
	                else rotate(nums,j,i);
	            }
	        }
	        else
	        {
	             if(nums[k]<0)
	            {
	                i=k;
	                j=k;
	                while(j<n && nums[j]<0) j++;
	                if(j>=n)  break;
	                else rotate(nums,i,j);
	            }
	        }
	        k++;
	    }
	    return nums;
	}
}
