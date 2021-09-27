class Solution {
    
    public boolean isSymmetric(TreeNode root) 
    {
        if(root==null) return true;
        return symmetric(root.left,root.right);
    }
    
    public boolean symmetric(TreeNode root1, TreeNode root2)
    {
        if(root1== null || root2==null)
            return root1==root2;
        if(root1.val != root2.val) return false;
        boolean one = symmetric(root1.left,root2.right); 
        boolean two = symmetric(root1.right,root2.left);
        return one && two;
    }
}
