class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> inOrder = new ArrayList<Integer>();
        if(root==null) return inOrder;
        while(true)
        {
            if(root!=null)
            {
                stack.push(root);
                root=root.left;
            }
            else
            {
                if(stack.isEmpty()) break;
                root=stack.pop();
                inOrder.add(root.val);
                root=root.right;
            }
        }
        return inOrder;
        
    }
}

