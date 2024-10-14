class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n= nums.length;
        for(int i=0;i<n;i++){
            pq.offer(nums[i]);
        }
        long score=0;
        while(k>0){
            int val = pq.poll();
            score+=val;
            pq.offer((int)Math.ceil(val/3.0));
            k--;
        }
        return score;
    }
}
