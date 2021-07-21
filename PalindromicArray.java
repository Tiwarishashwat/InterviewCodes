	public static int palinArray(int[] a, int n)
           {
                  //add code here.
//     Traverse all array elements one by one
                  for(int num: a)
                  {
//                     Convert array element to string
                   String number = String.valueOf(num);
//                     Get the first and last index
                   int i=0;
                   int j=number.length()-1;
//                     Check if element is palindrome or not
                   while(i<j)
                   {
                       if(number.charAt(i)!=number.charAt(j))
                       return 0;
                       i++;j--;
                   }
                   
                  }
                  return 1;
           }
