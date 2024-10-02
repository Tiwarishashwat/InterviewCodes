//Relative Sorting
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> indexArr = new ArrayList<>();
        for(int i=0;i<n;i++){
            indexArr.add(i);
        }
        Collections.sort(indexArr, new Comparator<Integer>(){
            public int compare(Integer x, Integer y){
                return arr[x] - arr[y]; //cust comp, inc sort
            }
        });
        int rank=0;
        int prev=Integer.MAX_VALUE;
        int res[] = new int[n];
        for(int index : indexArr){
            if(prev!=arr[index]){
                prev = arr[index];
                rank++;
            }
            res[index] = rank;
        }
        return res;
    }
}

//Priority Queue
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        //(element, index)
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int x[], int y[]){
                return x[0] - y[0]; //cust comp, inc sort
            }
        });
        for(int i=0;i<n;i++){
            pq.offer(new int[]{arr[i],i});
        }
       
        int rank=0;
        int prev=Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            int cur[] = pq.poll();
            if(prev!=cur[0]){
                prev = cur[0];
                rank++;
            }
            arr[cur[1]] = rank;
        }
        return arr;
    }
}


// TreeSet Approach
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        for (int element : arr) {
            set.add(element);
        }
        int rank = 1;
        for (int num : set) {
            map.put(num, rank);
            rank++;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}
