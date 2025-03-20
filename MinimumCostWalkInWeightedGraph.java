class DSU {
    int rank[];
    int parent[];
    DSU(int n){
        rank = new int[n];  //0
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
    }
    public int find(int node){
        if(node == parent[node]){
            return node;
        }
        parent[node] = find(parent[node]);
        return parent[node];
    }
    public void union(int node1, int node2){
        int rootParent1 = find(node1);
        int rootParent2 = find(node2);
        if(rootParent1 == rootParent2){
            return;
        }
        if(rank[rootParent1] < rank[rootParent2]){
            parent[rootParent1] = rootParent2;
        }else if(rank[rootParent2] < rank[rootParent1]){
            parent[rootParent2] = rootParent1;
        }else{
            parent[rootParent2] = rootParent1;
            rank[rootParent1]++;
        }
    }
}

class Solution {
    // tc: 2v + n + m
    // sc: n
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        DSU dsu = new DSU(n);
        // V
        for(int edge[] : edges){
            dsu.union(edge[0], edge[1]);
        }
        int compCost[] = new int[n];
        // N
        Arrays.fill(compCost,Integer.MAX_VALUE);
        // V
        for(int edge[] : edges){
            int rootParent = dsu.find(edge[0]);
            compCost[rootParent] = compCost[rootParent] & edge[2]; 
        }
        int m = query.length;
        int res[]= new int[m];
        // M
        for(int i=0;i<m;i++){
            int rootParent1 = dsu.find(query[i][0]);
            int rootParent2 = dsu.find(query[i][1]);
            if(rootParent1!=rootParent2){
                res[i] = -1;
            }else{
                res[i] = compCost[rootParent1];   
            }
        }
        return res;
    }
}






