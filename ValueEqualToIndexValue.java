class Solution {
    ArrayList<Integer> valueEqualToIndex(int arr[], int n) {
        // code here
        ArrayList<Integer> list = new ArrayList<>(); 
        for(int i=0;i<n;i++)
        {
            int val = arr[i];
            int reqIn = i+1;
            if(val == reqIn)
            {
                list.add(val);
            }
        }
      return list;
    }
}
