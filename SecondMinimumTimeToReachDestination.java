class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        int timeTaken[][] = new int[n+1][2]; //visited for 1st and 2nd time
        for(int i=0;i<n+1;i++){
            Arrays.fill(timeTaken[i],Integer.MAX_VALUE);
        }
        // O(2(V+E))
        // O(V) + 2v + V*E
        Queue<int[]> queue = new LinkedList<>();
        timeTaken[1][0] = 0; 
        queue.offer(new int[]{1,0});
        while(!queue.isEmpty()){
            int element[] = queue.poll();
            int node = element[0];
            int curTime = element[1];
            if(node == n){
                if(timeTaken[node][1]!=Integer.MAX_VALUE){
                    break;
                }
            }
            //if signal if red, add wait time and keep moving 
            if ((curTime / change) % 2 !=0){
                int waitTime = change - (curTime%change);
                curTime = curTime + waitTime + time;
            }else{ //if signal is green, keep moving
                curTime = curTime + time;
            }
            for(int neighbour : adj.get(node)){
                // level - 1: A (6)
                if (timeTaken[neighbour][0] == Integer.MAX_VALUE){ //first time visit
                    timeTaken[neighbour][0] = curTime;
                    queue.offer(new int[]{neighbour, curTime});
                }
                // level - 1: A (6)
                //second time visit but at different level(very important)
                // 3, 6 ,9..
                else if(timeTaken[neighbour][1] == Integer.MAX_VALUE && curTime > timeTaken[neighbour][0]){ 
                    timeTaken[neighbour][1] = curTime;
                    queue.offer(new int[]{neighbour, curTime});
                }
            }
        }
        return timeTaken[n][1];
    }
}
