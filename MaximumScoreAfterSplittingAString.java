// two pass
class Solution {
    public int maxScore(String s) {
        //find all the ones
        int ones = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '1') ones++;
        }
        // find max partition
        int res = 0;
        int zeros=0;
        for(int i=0;i<n-1;i++){
            if(s.charAt(i) == '0') zeros++;
            else ones--; 
            res = Math.max(res, ones + zeros);
        }
        return res;
    }
}

// single pass
class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int ones = 0;
        // find max partition
        int maxDiff = -1;
        int zeros=0;
        for(int i=0;i<n-1;i++){
            if(s.charAt(i) == '0') zeros++;
            else ones++; 
            maxDiff = Math.max(maxDiff, zeros - ones);
        }
        if(s.charAt(n-1)=='1') ones++;
        return (maxDiff + ones);
    }
}
