class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer,Integer> colorMap = new HashMap<>();
        HashMap<Integer,Integer> ballMap = new HashMap<>();   
        int n = queries.length;
        int res[] = new int[n];
        for(int i=0;i<n;i++){
            int ball = queries[i][0];
            int color = queries[i][1];
            if(ballMap.containsKey(ball)){
                int oldColor = ballMap.get(ball);
                colorMap.put(oldColor, colorMap.get(oldColor)-1);
                if(colorMap.get(oldColor)==0){
                    colorMap.remove(oldColor);
                }
            }
            ballMap.put(ball,color);
            colorMap.put(color, colorMap.getOrDefault(color,0)+1);
            res[i] = colorMap.size();
        }
        return res;
    }
}
