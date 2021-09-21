class Solution {
    public int maxPathSum(TreeNode root) {
        int arr[] = new int[1];
        arr[0] = Integer.MIN_VALUE;
        maxiPathSum(root,arr);
        return arr[0];
    }
    
    public int maxiPathSum(TreeNode root, int arr[])
    {
        if(root == null ) return 0;
        
        int leftSum = Math.max(maxiPathSum(root.left,arr),0);
        int rightSum = Math.max(maxiPathSum(root.right,arr),0);
        arr[0] = Math.max(arr[0],root.val + leftSum+rightSum);
        return root.val + Math.max(leftSum,rightSum);
    }
}
