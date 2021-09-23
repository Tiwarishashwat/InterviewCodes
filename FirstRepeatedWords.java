import java.util.*;
public class Main
{
  public static void main(String args[])
  {
    firstRepeatedWord("shashwat had been saying that he had been coding");
  }
  public static void firstRepeatedWord(String str)
  {
      HashSet<String> set = new HashSet<>();
    if(str.length()==0)
    {
      System.out.println("Not Found!");
      return;
    }
    String words[] = str.split(" ");
    for(String s : words)
    {
      if(set.contains(s))
      {
        System.out.println("First repeated is: "+s);
        return;
      }
      set.add(s);
    }
    System.out.println("Not Found");
  }
}
