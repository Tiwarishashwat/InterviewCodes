class Solution {
    static ArrayList<Integer> factorial(int n){
        
        ArrayList<Integer> res = new ArrayList<>();
        res.add(0,1);
        int res_size = 1;
        for(int x = 2; x <= n; x++)
        {
            int carry = 0; 
        for(int i=res_size-1;i>=0;i--)
        {
            int prod = res.get(i) * x + carry;
            res.set(i,prod % 10); // Store last digit of 'prod' in res[]
            carry = prod/10; // Put rest in carry
        }
 
        // Put carry in res and increase result size
        while (carry!=0)
            {
                res.add(0,carry % 10);
                carry = carry / 10;
                res_size++;
            }
        }
            return res;
        }
    }
