class Solution
{
	ArrayList <Integer> printBoundary(Node node)
	{
	    ArrayList<Integer> list = new ArrayList<>();
	    if(node.left!=null || node.right!=null) list.add(node.data); 
	    leftBoundary(node,list);
	    leafNodes(node,list);
	    rightBoundary(node,list);
	    return list;
	}
	
	void leftBoundary(Node node, ArrayList<Integer> list)
	{
	    node=node.left;
	    if(node==null) return;
	    while(node!=null)
	    {
	        if(node.left!=null || node.right!=null ) list.add(node.data);
	        if(node.left!=null) node=node.left;
	        else node=node.right;
	    }
	}
	
	void rightBoundary(Node node, ArrayList<Integer> list)
	{
	    node=node.right;
	    Stack<Integer> stack = new Stack<Integer>();
	    if(node==null) return;
	    while(node!=null)
	    {
	        if(node.left!=null || node.right!=null ) stack.push((node.data));
	        if(node.right!=null) node=node.right;
	        else node=node.left;
	    }
	    while(!stack.isEmpty())
	    {
	        list.add(stack.pop());
	    }
	}
	
	void leafNodes(Node node, ArrayList<Integer> list)
	{
	    if(node.left==null && node.right==null) 
	    {
	        list.add(node.data);
	        return;
	    }
	    if(node.left!=null) leafNodes(node.left,list);
	    if(node.right!=null) leafNodes(node.right,list);
	}
}
