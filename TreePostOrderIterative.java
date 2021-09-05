class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrder = new ArrayList<Integer>();
        if(root==null) return postOrder;
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
         Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(root);
        while(!stack1.isEmpty())
        {
            TreeNode temp = stack1.pop();
            if(temp.left!=null)  stack1.push(temp.left);
            if(temp.right!=null)  stack1.push(temp.right);
            stack2.push(temp);
        }
        while(!stack2.isEmpty())
        {
            postOrder.add(stack2.pop().val);
        }
        return postOrder;
    }
}
