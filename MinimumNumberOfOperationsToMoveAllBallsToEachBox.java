// three array
class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int left[]=new int[n];
        int right[]=new int[n];
        int res[]=new int[n];
        left[0]=0;
        right[n-1]=0;
        // '1' - '0' = 1
        // '0' - '0' = 0
        int count=boxes.charAt(0)-'0';
        //left
        for(int i=1;i<n;i++)
        {
            left[i]= left[i-1]+count;
            count+=boxes.charAt(i)-'0';
        }
        //right
        count=boxes.charAt(n-1)-'0';
        for(int i=n-2;i>=0;i--)
        {
            right[i]= right[i+1]+count;
            count+=boxes.charAt(i)-'0';
        }
        for(int i=0;i<n;i++)
        {
            res[i]=left[i]+right[i];
        }
        return res;  
    }
}

// single array
class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        // O(N)
        int left[]=new int[n];
        left[0]=0;
        int count=boxes.charAt(0)-'0';
        //left - O(N)
        for(int i=1;i<n;i++)
        {
            left[i]= left[i-1]+count;
            count+=boxes.charAt(i)-'0';
        }
        //right - O(N)
        count=boxes.charAt(n-1)-'0';
        int prevRight=0;
        int curRight=0;
        for(int i=n-2;i>=0;i--)
        {
            curRight = prevRight + count;
            prevRight = curRight;
            left[i] = left[i] + curRight;
            count+=boxes.charAt(i)-'0';
        }
        return left;  
    }
}
