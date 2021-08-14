import java.util.*;
class DuplicateCount{
  public static void main(String args[])
  {
    String s = "SHASHWAT";
    countDuplicates(s);
  }
  public static void countDuplicates(String inp)
  {
    HashMap<Character,Integer> map = new HashMap<>();
    for(int i=0;i<inp.length();i++)
    {
      map.put(inp.charAt(i),map.getOrDefault(inp.charAt(i),0)+1);
    }
    for(Map.Entry<Character,Integer> e : map.entrySet())
    {
      System.out.println(e.getKey() + ":" + e.getValue());
    }
  }
}
