class Solution 
{
    // return either a perfect square root or floor value
     public static int mySqrt(int N ) {
        int start=1;
        int end=N;
        while(start<=end)
        {
            int mid = start+(end-start)/2;
            if(mid<=N/mid) 
            {
                if(N%mid==0 && mid==N/mid)
                {
                    return mid;
                }
                start=mid+1;
            }
            else end=mid-1;
        }
        return start;
    }
    static int countSquares(int N) {
        // code here
        int sqrRoot = mySqrt(N);
        return sqrRoot-1;
    }
}

// 1. find the square root
// 2. if N is a perfect square then return squareroot -1
// 3. if N is not a perfect sqaure then return ceil(sqaureroot)-1
