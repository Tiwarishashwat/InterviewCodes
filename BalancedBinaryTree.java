class Solution {
    public int maxDepth(TreeNode root)
    {
        //   Base Case
        if(root==null) return 0;
        // recursion calls
        int lh=maxDepth(root.left);
        int rh=maxDepth(root.right);
        // non favourable
        if(lh==-1 || rh==-1) return -1;
        if(Math.abs(lh-rh)>1) return -1;
        // depth of the tree
        return 1+Math.max(lh,rh);
    }
    
    public boolean isBalanced(TreeNode root) {
        if(maxDepth(root)==-1) return false;
        return true;
        
    }
}

