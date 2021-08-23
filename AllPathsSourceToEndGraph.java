class Solution {
    
    public static void backTrack(int graph[][], int element, List<List<Integer>> list,List<Integer> sublist){
        // Base Case 
        if(element==graph.length-1)
        {
            list.add(new ArrayList<>(sublist));
            return;
        }
        
        for(int i=0;i<graph[element].length;i++)
        {
            sublist.add(graph[element][i]);
            backTrack(graph,graph[element][i],list,sublist);
            sublist.remove(sublist.size()-1);
        }
    }
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> sublist = new ArrayList<Integer>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        sublist.add(0);
        backTrack(graph,0,list,sublist);
        return list;
    }
}
