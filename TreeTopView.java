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
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
        ArrayList<Integer> list = new ArrayList<>();
           
        if(root==null) return list;
        
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(root,0));
        
        while(!q.isEmpty())
        {
            Pair p = q.remove();
            
            int v = p.vertical;
            
            Node node = p.node;
            
            if(map.get(v)==null)
            {
                map.put(v,node.data);
            }
            
            if(node.left!=null)
            {
                q.add(new Pair(node.left,v-1));
            }
            
              if(node.right!=null)
            {
                q.add(new Pair(node.right,v+1));
            }
        }
       for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            list.add(entry.getValue()); 
       }
        return list;
        
    }
    
}
