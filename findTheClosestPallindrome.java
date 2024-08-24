class Solution {
    public long findNearestPallindrome(long firstHalf, boolean isOdd){
        long res = firstHalf; //12 21 -> 1221, 12 2 21 -> 12221
        if(isOdd){
            firstHalf/=10;
        }
        while(firstHalf>0){
            res = res *10 + (firstHalf%10);
            firstHalf/=10;
        }
        return res;
    }
    public String nearestPalindromic(String n) {
        ArrayList<Long> list = new ArrayList<Long>();
        int len = n.length();
        boolean isOdd = (len%2!=0);
        //copy first half
        int mid = (len%2==0)?(len/2):(len/2+1);
        Long firstHalf = Long.parseLong(n.substring(0,mid));
        list.add(findNearestPallindrome(firstHalf,isOdd));
        list.add(findNearestPallindrome(firstHalf+1,isOdd));
        list.add(findNearestPallindrome(firstHalf-1,isOdd));
        list.add((long)Math.pow(10,len-1)-1); //all 9's
        list.add((long)Math.pow(10,len)+1); //101,1001,10001...
        long num = Long.parseLong(n);
        long minDiff = Long.MAX_VALUE;
        long res = Long.MAX_VALUE;
        for(Long element : list){
            if(element == num) continue;
            long curDiff = Math.abs(element - num);
            if(curDiff < minDiff){
                res = element;
                minDiff = curDiff;
            }else if(curDiff == minDiff){
                res = Math.min(res,element);
            }
        }
        return String.valueOf(res);

    }
    
}
