class Solution {
    public int[] processQueries(int[] queries, int m) {
        List<Integer> result = new ArrayList<>();
        int ans[] = new int[queries.length];
        for(int i=1;i<=m;i++)
        {
            result.add(i);
        }
        for(int i=0;i<queries.length;i++)
        {
            for(int j=0;j<=m;j++)
            {
                if(result.get(j)==queries[i])
                {
                    ans[i]=j;
                    result.remove(j);
                    result.add(0,queries[i]);
                    break;
                }
            }
        }
        return ans;        
    }
}
