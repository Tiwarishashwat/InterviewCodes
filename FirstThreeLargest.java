public class FirstThreeLargest{
  public static void Main(String args[])
  {
    int arr[] = {2,7,9,3,6,1,11,8};
    solve(arr);
  }
  public static void solve(int arr[])
  {
    int n=arr.length;
    int first = Integer.MIN_VALUE, second=Integer.MIN_VALUE,third=Integer.MIN_VALUE;
    for(int i=0;i<n;i++)
    {
      if(first<=arr[i])
      {
        third = second;
        second = first;
        first = arr[i];
      }
      else if(second<=arr[i])
      {
        third = second;
        second = arr[i];
      }
      else if(third<=arr[i])
      {
          third = arr[i];
      }
    }
    System.out.println(first + " " + second + " "+ third);
  }
}
