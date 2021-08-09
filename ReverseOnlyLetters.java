class Solution {
    public String reverseOnlyLetters(String s) {
        char[] arr = new char[s.length()];
        int end=arr.length-1;
        for(int i=0;i<s.length();i++)
        {
          if(Character.isLetter(s.charAt(i)))
            {
                while(!Character.isLetter(s.charAt(end))) end--;
                arr[end]=s.charAt(i);
                end--;
            }
            else arr[i]=s.charAt(i);
        }
        return String.valueOf(arr);
    }
}

