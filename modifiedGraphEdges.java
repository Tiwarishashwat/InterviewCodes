class Solution {

    List<int[]>[] graph;
    int INF = (int)1e9;

    public int[][] modifiedGraphEdges(int n,int[][] edges,int source,int destination,int target) {
        //form the adjlist
        // init
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        // exclude node with -1 value;
        for (int[] edge : edges) {
            if (edge[2] != -1) {
                graph[edge[0]].add(new int[] { edge[1], edge[2] });
                graph[edge[1]].add(new int[] { edge[0], edge[2] });
            }
        }
        int minDist = runDijkstra(n, source, destination);
        //not possible to meet target
        if (minDist < target) {
            return new int[0][0];
        }
        // we don't need -1 weighted edges
        if (minDist == target) {
            for (int[] edge : edges) {
                if(edge[2] == -1){
                    edge[2] = INF;
                }
            }
            return edges;
        }
        // if minDist > target (we can further reduce the minDist)
        boolean matchesTarget = false;
        for (int[] edge : edges) {
            if (edge[2] != -1) continue;
            edge[2] = matchesTarget ? INF : 1;
            graph[edge[0]].add(new int[] { edge[1], edge[2] });
            graph[edge[1]].add(new int[] { edge[0], edge[2] });
            if (!matchesTarget) {
                int newDistance = runDijkstra(n, source, destination);
                if (newDistance <= target) {
                    matchesTarget = true;
                    edge[2] += target - newDistance;
                }
            }
        }
        return matchesTarget ? edges : new int[0][0];
    }

    // Dijkstra's algorithm to find the shortest path from source to destination
    private int runDijkstra(int n, int source, int destination) {
        int[] minDistance = new int[n];
        boolean[] visited = new boolean[n];
        // sort in increasing order of edge weight
        // [u,w] (node, weight to node)
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int a[], int b[]){
                return a[1] - b[1];
            }
        });

        Arrays.fill(minDistance, INF);
        minDistance[source] = 0;
        queue.add(new int[] { source, 0 });

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int u = curr[0];
            int d = curr[1];

            if (d > minDistance[u]) continue;

            for (int[] neighbour : graph[u]) {
                int v = neighbour[0];
                int weight = neighbour[1];

                if (d + weight < minDistance[v]) {
                    minDistance[v] = d + weight;
                    queue.add(new int[] { v, minDistance[v] });
                }
            }
        }

        return minDistance[destination];
    }
}
