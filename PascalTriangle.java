class Solution 
{
    public List<List<Integer>> generate(int numRows) 
    {
//         Declare an array List for storing the result
        List<List<Integer>> pascalTriangle = new ArrayList<List<Integer>>();
        pascalTriangle.add(0,new ArrayList<>(Arrays.asList(1)));
//         Variable to keep track of each row
        int i=2;
//         Calculating value of each row of pascal triangle
        while(i<=numRows)
        {
            int start=0,end=i-1;
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(start,1);
            start++;
            for(int j=start;j<end;j++)
            {
                int sum = pascalTriangle.get(i-2).get(j-1)+pascalTriangle.get(i-2).get(j);
                temp.add(j,sum);
            }
            temp.add(end,1);
            pascalTriangle.add(temp);
            i++;
        }
        return pascalTriangle;
    }
}
