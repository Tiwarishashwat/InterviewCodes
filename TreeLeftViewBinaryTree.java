class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      ArrayList<Integer> list = new ArrayList<>();
      if(root==null) return list;
      Queue<Node> queue = new LinkedList<>();
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
              if(i==0)
              {
                  list.add(queue.peek().data);
              }
              queue.remove();
          }
      }
      return list;
    }
}
