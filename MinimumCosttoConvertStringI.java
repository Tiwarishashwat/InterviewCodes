class Solution {
    long[] dijkstra(int S, long adj[][]){
        long dist[] = new long[26];
        for(int i=0;i<26;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[S] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>(){
            public int compare(long a[], long b[]){
                if(a[1]<=b[1]){
                    return -1;
                }
                return 1;
            }
        });
        pq.offer(new long[] {S,0});
        
        while(!pq.isEmpty()){
            long element[] = pq.poll();
            long node = element[0];
            long distance = element[1];
            for(int i=0;i<26;i++){
                if(adj[(int)node][i]==Integer.MAX_VALUE){
                    continue;
                }
                long newDist = distance +  adj[(int)node][i]; 
                if(newDist<dist[i]){
                    dist[i] = newDist;
                    pq.offer(new long[]{i,newDist});
                }
            }
        }
        return dist;
    }
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        //adj list for directed graph
        long adj[][] = new long[26][26];
        for(int i=0;i<26;i++){
            Arrays.fill(adj[i],Integer.MAX_VALUE);
        }
        int n = original.length;
        for(int i=0;i<n;i++){
            int from = original[i]-97;
            int to = changed[i]-97;
            long converstionCost = cost[i];
            //since there are multiple values, take min.
            adj[from][to] = Math.min(adj[from][to], converstionCost);
        }
        int m = source.length();
        long matrix[][] = new long[26][26];
        HashSet<Integer> uniqueSrc = new HashSet<>();
        //apply Dijkstra's Algorithm
        for(int i=0;i<m;i++){
            int src = source.charAt(i)-97;
            if(!uniqueSrc.contains(src)){
                matrix[src] = dijkstra(src,adj);
                uniqueSrc.add(src);
            }
        }
        long minCost = 0;
        for(int i=0;i<m;i++){
            int src = source.charAt(i)-97;
            int dest = target.charAt(i)-97;
            if(matrix[src][dest] == Integer.MAX_VALUE){
                return -1;
            }
            minCost += matrix[src][dest];
        }
    return minCost;
    }
}
