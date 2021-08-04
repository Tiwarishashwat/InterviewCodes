/*Complete the function given below*/
class Solution {
    
    public static int findMax(int arr[], int n)
    {
        int res=0,h=0,p=0,i=1;
        Stack<Integer> startPos = new Stack<>();
        Stack<Integer> height = new Stack<>();
        startPos.push(0);
        for(i=0;i<n;i++)
        {
            // Empty or when a bigger value arrives we start a new rectangle
            if(height.isEmpty() || arr[i]>height.peek())
            {
                startPos.push(i);
                height.push(arr[i]);
            }
            // Pop logic
            else if( arr[i]<height.peek())
            {
                while(!height.isEmpty() && arr[i]<height.peek())
                {
                    h=height.pop();
                    p=startPos.pop();
                    res=Math.max(res,h*(i-p));
                }
                // Store the last popped value to retrive the current value's starting
                startPos.push(p);
                height.push(arr[i]);
            }
        }
        // Remaining values
        while(!height.isEmpty())
        {
            h=height.pop();
            p=startPos.pop();
            res=Math.max(res,h*(i-p));
        }
        return res;
    }
    
    public int maxArea(int M[][], int m, int n) {
        // add code here.
      int res=0;
      int arr[] = new int[n];
      
    //   Traverse the matrix
    for(int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++)
        {
            if(M[i][j]==0)
            {
                arr[j]=0;
            }
            else
            {
                arr[j] = arr[j] + M[i][j];
            }
        }
        // Calculate result so far
        res=Math.max(res,findMax(arr,n));
    }
    return res;
    }
}
