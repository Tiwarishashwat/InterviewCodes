class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        if(root == null) return list;
        
        boolean flag = true;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            int level = queue.size();
            List<Integer> subList = new ArrayList<>();
            for(int i=0;i<level;i++)
            {
                if(queue.peek().left!=null) queue.add(queue.peek().left);
                if(queue.peek().right!=null) queue.add(queue.peek().right);
                if(flag==true)
                {
                    subList.add(queue.remove().val);
                }
                else
                {
                     subList.add(0,queue.remove().val);
                }
            }
            flag = !flag;
            list.add(subList);
        }
        return list;
        
    }
}
