class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        int dist[] = new int[V];
        for(int i=0;i<V;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[S] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int a[], int b[]){
                return a[1] - b[1];
            }
        });
        pq.offer(new int[] {S,0});
        
        while(!pq.isEmpty()){
            int element[] = pq.poll();
            int node = element[0];
            int distance = element[1];
            for(ArrayList<Integer> neighbour : adj.get(node)){
                int newDist = distance +  neighbour.get(1);
                if(newDist<dist[neighbour.get(0)]){
                    dist[neighbour.get(0)] = newDist;
                    pq.offer(new int[]{neighbour.get(0),newDist});
                }
            }
        }
        return dist;
    }
}
