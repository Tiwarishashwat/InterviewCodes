//dp
class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int dp[][] = new int[n][n];
        int maxLen=0;
        for(int cur=2;cur<n;cur++){
            int start = 0;
            int end = cur-1;
            while(start<end){
                int sum = arr[start] + arr[end];
                if(sum < arr[cur]){
                    start++;
                }else if(sum > arr[cur]){
                    end--;
                }else{
                    dp[end][cur] = dp[start][end] + 1;
                    maxLen = Math.max(maxLen, dp[end][cur]);
                    start++;
                    end--;
                }
            }
        }
        return (maxLen==0)?0:maxLen + 2;
    }
}

// brute force
class Solution {

    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Set<Integer> numSet = new HashSet<>();
        for (int num : arr) {
            numSet.add(num);
        }
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int prev = arr[j];
                int curr = arr[i] + arr[j];
                int len = 2;
                while (numSet.contains(curr)) {
                    int temp = curr;
                    curr += prev;
                    prev = temp;
                    maxLen = Math.max(maxLen, ++len);
                }
            }
        }
        return maxLen;
    }
}

