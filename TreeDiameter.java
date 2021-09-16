class Solution {
    int maxi=0;
    public int diameterOfBinaryTree(TreeNode root) {
        
        if(root == null) return 0;
        int ans[]=new int[1];
        findDiameter(root,ans);
        return ans[0];
        
    }
    public int findDiameter(TreeNode root, int maxi[])
    {
        if(root == null) return 0;
        int left = findDiameter(root.left,maxi);
        int right = findDiameter(root.right,maxi);
        maxi[0]=Math.max(maxi[0],left+right);
        return 1+Math.max(left,right);
}
}
