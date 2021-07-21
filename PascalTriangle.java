class Solution 
{
    public List<List<Integer>> generate(int numRows) 
    {
        // Declare list of list for storing results
        List<List<Integer>> pascalTriangle = new ArrayList<List<Integer>>();
        pascalTriangle.add(0,new ArrayList<Integer>(Arrays.asList(1)));
        
        int row =2;
        
        while(row<=numRows)
        {
            List<Integer> temp = new ArrayList<>();
            temp.add(0,1);
            int start=1,end=row-1;
            for(int i=start;i<end;i++)
            {
                int sum = pascalTriangle.get(row-2).get(i-1)+pascalTriangle.get(row-2).get(i);
                temp.add(i,sum);
            }
            temp.add(end,1);
            pascalTriangle.add(temp);
            row++;
        }
        return pascalTriangle;
    }
}


