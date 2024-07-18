/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int res=0;
  public int[] dfs(TreeNode root, int distance){
        int leafDist[] = new int[11];
        if(root==null){
            return leafDist;
        }else if(root.left==null && root.right==null){
            leafDist[1] = 1;
            return leafDist;
        }
        int leftLeafDist[] = dfs(root.left,distance);
        int rightLeafDist[] = dfs(root.right,distance);

        for(int d1=1;d1<=distance;d1++){
            for(int d2=1;d2<=distance;d2++){
                if(d1+d2<=distance){ 
                    res += leftLeafDist[d1] * rightLeafDist[d2];
                }
            }    
        }
        for(int d=1;d<11;d++){
            leafDist[d] = leftLeafDist[d-1] + rightLeafDist[d-1];
        }
        return leafDist;
  }
  public int countPairs(TreeNode root, int distance) {
        dfs(root,distance);
        return res;
  }
}



