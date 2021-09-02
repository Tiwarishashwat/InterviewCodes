class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> preOrder = new ArrayList<Integer>();
        if(root==null) return preOrder;
        stack.push(root);
        while(!stack.isEmpty())
        {
            root=stack.pop();
            preOrder.add(root.val);
            if(root.right!=null)
            {
                stack.push(root.right);
            }
            if(root.left!=null)
            {
                stack.push(root.left);
            }
        }
        return preOrder;
    }
}
