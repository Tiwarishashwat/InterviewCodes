class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
           List<List<Integer>> list = new ArrayList<List<Integer>>(); 
        if(root==null) return list;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);  
        while(!queue.isEmpty())
        {
            int nodesPresent=queue.size();
            List<Integer> sublist = new ArrayList<Integer>();
            for(int i=0;i<nodesPresent;i++)
            {
                if(queue.peek().left!=null) queue.offer(queue.peek().left);
                if(queue.peek().right!=null) queue.offer(queue.peek().right);
                sublist.add(queue.poll().val);
            }
            list.add(sublist);
        }
        return list;
    }
}
