class Solution {
    public int minGroups(int[][] intervals) {
        //find range
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = intervals.length;
        for(int i=0;i<n;i++){
            min = Math.min(min, intervals[i][0]);
            max = Math.max(max, intervals[i][1]);
        }  
        int eventCount[] = new int[max+2];
        // find the count
        for(int i=0;i<n;i++){
            eventCount[intervals[i][0]]++;
            eventCount[intervals[i][1]+1]--;
        } 
        int maxOverlaps = 0;
        int sum=0;
        for(int i=min;i<max+2;i++){
            sum+=eventCount[i];
            maxOverlaps = Math.max(maxOverlaps, sum);
        }
        return maxOverlaps;
    }
}
