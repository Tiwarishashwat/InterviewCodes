class Solution {
    // [element, index]
    int mod = (int)1e9+7;
    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int a[], int b[]){
                return a[0] - b[0];
            }
        });
        for(int i=0;i<n;i++){
            pq.offer(new int[]{nums[i],i});
        }
        int sum=0;
        for(int index=0;index<right;index++){
            int cur[] = pq.poll();
            if(index >= left-1){
                sum = (sum + cur[0])%mod;
            }
            // [3,2]
            if(cur[1]+1<n){
                cur[1]++;
                cur[0] = cur[0] + nums[cur[1]];
                pq.offer(cur);
            }
        }
        return sum;
    }
}
