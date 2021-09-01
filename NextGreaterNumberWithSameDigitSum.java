import java.util.*;
public class NextGreaterNumberWithSameDigitSum{
  public static void main(String args[])
  {
    Scanner obj = new Scanner(System.in);
    System.out.println("Enter Number");
    int n=obj.nextInt();
    sol(n);
  }
  public static void sol(int n)
  {
    String trailingZeros="";
    String decrement="";
    String midNines="";
    String rem="";
    String num=String.valueOf(n);
    int start=0,end=num.length()-1;
    int numZeros=0;
    int numNine=0;
    // Find the trailingZeros
    while(end>=start)
    {
      if(num.charAt(end)=='0') numZeros++;
      else break;
      end--;
    }

    // Modify Number of Zeros
    while(numZeros>0)
    {
      trailingZeros+="0";
      numZeros--;
    }

    // decrement the value
    int x=(num.charAt(end)-'0')-1;
    decrement+=x;
    // changed the index after decrement
    end--;

    // Find the midNines
    while(end>=start)
    {
      if(num.charAt(end)=='9') numNine++;
      else break;
      end--;
    }

    // Modify Number of Zeros
    while(numNine>0)
    {
      midNines+="9";
      numNine--;
    }

    // increment the value
    // cases like 80 where you need to insert 1
    if(end==-1)
    {
      rem="1";
    }
    else
    {
      int y=(num.charAt(end)-'0')+1;
      rem = rem+ num.substring(0,end) +y;
    }
    System.out.println(rem+trailingZeros+decrement+midNines);
  }
}
