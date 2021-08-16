class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int output[] = new int[n];
        boolean ans=backtrack(1,paths,output,n+1);
        return output;
    }
    
    public boolean backtrack(int garden,int path[][], int output[],int n)
    {
        if(garden == n)
            return true;
        for(int i=1;i<=4;i++)
        {
            if(isFeasible(garden,path,output,i))
            {
                output[garden-1]=i;   
                if(backtrack(garden+1,path,output,n))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isFeasible(int garden,int path[][],int output[],int color)
    {
        for(int i=0;i<path.length;i++)
        {
            if(path[i][0]==garden)
            {
                if(output[path[i][1]-1]==color) return false;
            }
            else if(path[i][1]==garden)
            {
                if(output[path[i][0]-1]==color) return false;
            }
        }
        return true;
    }   
}
