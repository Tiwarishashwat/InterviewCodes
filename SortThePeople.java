class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = heights.length;
        Integer index[] = new Integer[n];
        //ON
        for(Integer i=0;i<n;i++){
            index[i] = i;
        }
        //NlogN
        //merge sort, quick sort ....
        Arrays.sort(index, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return heights[b] - heights[a];
            }
        });
        String res[] = new String[n];
        int i=0;
        // On
        for(Integer ind : index){
            res[i] = names[ind];
            i++;
        }
        return res;
        
    }
}
