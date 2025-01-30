class Solution {
    // n * (n+m)
    public int magnificentSets(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        //1 to n => 0 to n-1
        // u-v
        // u -> [v]
        // v -> [u]
        for (int[] edge : edges) {
            adjList.get(edge[0] - 1).add(edge[1] - 1);
            adjList.get(edge[1] - 1).add(edge[0] - 1);
        }

        //bipartite graph
        // 0-> not visited
        // 1-> color1
        // -1-> color2
        // n+m
        int[] colors = new int[n];
        for (int node = 0; node < n; node++) {
            if (colors[node] != 0) continue;
            colors[node] = 1;
            if (!isBipartite(adjList, node, colors)) return -1;
        }
        // n * (n + m)
        int[] distances = new int[n];
        for (int node = 0; node < n; node++) {
            distances[node] = getLongestLength(adjList, node, n);
        }
        // n+m
        int maxNumberOfGroups = 0;
        boolean[] visited = new boolean[n];
        for (int node = 0; node < n; node++) {
            if (visited[node]) continue;
            maxNumberOfGroups += getNumberOfGroupsForComponent(adjList,node,distances,visited);
        }
        return maxNumberOfGroups;
    }

    // Checks if the graph is bipartite - DFS
    private boolean isBipartite(ArrayList<ArrayList<Integer>> adjList,int node,int[] colors) {
        for (int neighbor : adjList.get(node)) {
            if (colors[neighbor] == colors[node]) return false; //check for same color
            if (colors[neighbor] != 0) continue; //already colored
            // green = 1 * -1 = -1 / blue = -1 * -1 =1
            colors[neighbor] = -1*(colors[node]); //not visited -> color
            if (!isBipartite(adjList, neighbor, colors)) return false;
        }
        return true;
    }

    private int getLongestLength(ArrayList<ArrayList<Integer>> adjList,int node,int n) {
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[n];
        queue.add(node);
        visited[node] = true;
        int distance = 0;

        while (!queue.isEmpty()) {
            int numOfNodesInLayer = queue.size();
            for (int i = 0; i < numOfNodesInLayer; i++) {
                int currentNode = queue.poll();
                for (int neighbor : adjList.get(currentNode)) {
                    if (visited[neighbor]) continue;
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
            distance++;
        }
        return distance;
    }

    // Calculates the maximum number of groups for a connected component
    private int getNumberOfGroupsForComponent(ArrayList<ArrayList<Integer>> adjList,int node,int[] distances,boolean[] visited) {
        // Start with the distance of the current node as the maximum
        int maxNumberOfGroups = distances[node];
        visited[node] = true;

        // Recursively calculate the maximum for all unvisited neighbors
        for (int neighbor : adjList.get(node)) {
            if (visited[neighbor]) continue;
            maxNumberOfGroups = Math.max(
                maxNumberOfGroups,
                getNumberOfGroupsForComponent(adjList,neighbor,distances,visited));
        }
        return maxNumberOfGroups;
    }
}
