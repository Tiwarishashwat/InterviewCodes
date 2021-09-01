import java.util.*;
class StringPermutation {
  public static void main(String args[])
  {
    String s="ABC";
    permute(0,s);
  }
  public static String swap(String s,int a,int b)
  {
    char ch[] = s.toCharArray();
    char p=ch[a];
    ch[a]=ch[b];
    ch[b]=p;
    return String.valueOf(ch);
  }
    public static void permute(int index, String s)
    {
      // bASE
      if(index==s.length()-1)
      {
        System.out.println(s);
        return;
      }

      // logic
      for(int i=index;i<s.length();i++)
      {
        // swap
        s=swap(s,i,index);
        // recursion
        permute(index+1,s);
        // backtrack
        s=swap(s,i,index);
      }

    }
}
