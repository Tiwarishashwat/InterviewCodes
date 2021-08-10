class Solution {
    public String reverseOnlyLetters(String s) { 
        char arr[] = s.toCharArray();
        int start=0,end=arr.length-1;
        
        while(start<end)
        {
            if(!Character.isLetter(arr[start])) start++;
            else  if(!Character.isLetter(arr[end])) end--;
            else
            {
                char p = arr[start];
                arr[start] = arr[end];
                arr[end] = p;
                start++;
                end--;
            }
        }
        return String.valueOf(arr);

    }
}

