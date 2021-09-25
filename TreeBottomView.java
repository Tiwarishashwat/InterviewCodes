class Pair{
    int vertical;
    Node node;
    Pair(Node n,int v)
    {
        vertical = v;
         node = n;
    }
}
class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        
        ArrayList<Integer> ans = new ArrayList<>(); 
        if(root == null) return ans;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0)); 
        while(!q.isEmpty()) {
             Pair temp = q.remove();
            int v = temp.vertical;
            Node n = temp.node;
            map.put(v, n.data); 
            if(n.left != null) {
                q.add(new Pair(n.left,v-1)); 
            }
            if(n.right != null) {
                q.add(new Pair(n.right,v+1)); 
            }
        }
        
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            ans.add(entry.getValue()); 
        }
        return ans; 
    }
}
