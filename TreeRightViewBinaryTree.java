class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
    // Your code here
      List<Integer> list = new ArrayList<>();
      if(root==null) return list;
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      while(!queue.isEmpty())
      {
          int level = queue.size();
          for(int i=0;i<level;i++)
          {
              if(queue.peek().left!=null) 
              {
                  queue.add(queue.peek().left);
              }
              if(queue.peek().right!=null)
              {
                  queue.add(queue.peek().right);
              }
              if(i==level-1)
              {
                  list.add(queue.peek().val);
              }
              queue.remove();
          }
      }
      return list;
        
    }
}
