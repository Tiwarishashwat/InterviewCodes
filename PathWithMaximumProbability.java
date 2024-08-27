class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double prob[] = new double[n];
        prob[start_node] = 1;
        //bellmanford
        for(int i=0;i<n-1;i++){
            int j=0;
            boolean isChanged=false;
            for(int edge[] : edges){ // j
                int u = edge[0];
                int v = edge[1];
                double sp = succProb[j];
                if(prob[u] * sp > prob[v]){
                    prob[v] = prob[u] * sp;
                    isChanged=true;
                }
                if(prob[v] * sp > prob[u]){
                    prob[u] = prob[v] * sp;
                    isChanged=true;
                }
                j++;
            }
            if(!isChanged){
                break;
            }
        }
        return prob[end_node];
    }
}
