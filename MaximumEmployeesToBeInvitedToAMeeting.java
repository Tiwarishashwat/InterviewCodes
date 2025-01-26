class Solution {
    public int maximumInvitations(int[] favorite) {
        // find complete cycles (len>2)
        int n = favorite.length;
        int longestCycle=0;
        // < [], [], [] ...>
        ArrayList<int[]> twoLenCycles = new ArrayList<>();
        boolean vis[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(vis[i]) continue;
            HashSet<Integer> set = new HashSet<>();
            int start = i;
            int cur = i;
            while(!vis[cur]){
                vis[cur] = true;
                set.add(cur);
                cur = favorite[cur];
            }
            int len = set.size();
            while(start!=cur){
                len--;
                start = favorite[start];
            }
            //len
            longestCycle = Math.max(longestCycle,len);
            if(len == 2){
                twoLenCycles.add(new int[]{cur,favorite[cur]});
            }
        }

        // find 2 len cycles (add if possible)
        List<List<Integer>> reverseList = new ArrayList<>();
        for(int i=0;i<n;i++){
            reverseList.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            reverseList.get(favorite[i]).add(i);
        }
        int max2lenCyclePath = 0;
        for(int arr[] : twoLenCycles){
            max2lenCyclePath += f(arr[0], arr[1],reverseList) + f(arr[1],arr[0],reverseList)  + 2;
        }
        // return max
        return Math.max(max2lenCyclePath,longestCycle);
    }
    private int f(int node, int skip, List<List<Integer>> reverseList){
        int len=0;
        // [node, len]
        Queue<int[]> queue = new LinkedList<>();
        // queue.offer(node);
        queue.offer(new int[]{node, 0});
        while(!queue.isEmpty()){
            int cur[] = queue.poll();
            len = Math.max(len, cur[1]);
            for(int neighbour:reverseList.get(cur[0])){
                if(neighbour == skip) continue;
                queue.offer(new int[]{neighbour, cur[1] + 1});
            }
        }
        return len;
    }
}
