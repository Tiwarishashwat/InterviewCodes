class Solution {
    public static void backTrack(int r, int c, int m[][], int n, ArrayList<String> list, String path, int visited[][])
    {
        // Dead Ends
        if(r<0 || c<0 || r>=n || c>=n || visited[r][c]==1 || m[r][c]==0)
        {
            if(path.length()>1)
                path=path.substring(0,path.length()-1);
            else 
                path="";
             return; 
        }
        // Base Case
         if(r==n-1 && c==n-1)
        {
            list.add(path);
            return;
        }
            visited[r][c]=1;
            backTrack(r+1,c,m,n,list,path+"D",visited);
            backTrack(r,c-1,m,n,list,path+"L",visited);
            backTrack(r,c+1,m,n,list,path+"R",visited);
            backTrack(r-1,c,m,n,list,path+"U",visited);
            // backtrack
            visited[r][c]=0;
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> list = new ArrayList<String>();
        int visited[][] = new int[n][n];
        backTrack(0,0,m,n,list,"",visited);
        return list;
    }
}
