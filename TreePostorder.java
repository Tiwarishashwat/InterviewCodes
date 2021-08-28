class Solution {
    	public void postorder(TreeNode node,List<Integer> list)
	    {
	        if(node==null) return;
	        postorder(node.left,list);
	        postorder(node.right,list);
	        list.add(node.val);
	    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        postorder(root,list);
        return list;
    }
}
