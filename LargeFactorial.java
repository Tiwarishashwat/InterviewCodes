//User function Template for Java

class Solution {
    static ArrayList<Integer> factorial(int n)
        {
        // declare an arrayList
        ArrayList<Integer> result = new ArrayList<Integer>();
        int size=0,c=0;
        // Adding 1 at 0th index
        result.add(0,1);
        // Updating size
        size=1;
        // Decalre a variable to traverse numbers from 2 to n
        int val=2;
        while(val<=n)
        {
            // Traverse array list from right to left
            for(int i=size-1;i>=0;i--)
            {
                // Update value in arrayList
                int temp=result.get(i)*val + c;
                // Store the last digit at index and add remaining to carry
                result.set(i,temp%10);
                // update carry
                c=temp/10;
            }
            // insert carry digit by digit to the begining of the ArrayList
            while(c!=0)
            {
                result.add(0,c%10);
                c=c/10;
                size++;
            }
            val++;
        }
       return result;
        }
    }
    
