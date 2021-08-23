public class StringSubsequences
{

  public static void main(String[] args)
  {
    subSequence("abc","",0);
  }

  public static void subSequence(String input, String output, int index)
  {

    // Base Case
    if(index>=input.length())
    {
      for(int i=0;i<output.length();i++)
      {
        System.out.print(output.charAt(i)+" ");
      }
      System.out.println();
      return;
    }

    // including element
    output=output+input.charAt(index);
    subSequence(input,output,index+1);

    // excluding element
    output=output.substring(0,output.length()-1);
    subSequence(input,output,index+1);
  }

}
