class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // V+E
        // V
        HashMap<Integer,Boolean> map = new HashMap<>();
        int n = graph.length;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(dfs(i,graph,map)){
                res.add(i);
            }
        }
        return res;
    }
    public boolean dfs(int node, int[][] graph, HashMap<Integer,Boolean> map){
        if(map.containsKey(node)){
            return map.get(node);
        }

        map.put(node,false);
        for(int neighbour : graph[node]){
            if(!dfs(neighbour, graph, map)){
                return false;
            }
        }
        map.put(node,true);
        return true;
    }
}
