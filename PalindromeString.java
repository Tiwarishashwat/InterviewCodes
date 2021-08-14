class Solution {
    int isPlaindrome(String S) {
        // code here
        int start=0;
        int end=S.length()-1;
        while(start<end)
        {
         if(S.charAt(start)!=S.charAt(end))
         {
             return 0;
         }
         start++;
         end--;
        }
        return 1;
    }
}
