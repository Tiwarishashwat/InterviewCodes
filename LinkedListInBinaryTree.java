class Solution {
    public boolean dfs(ListNode head, TreeNode node){
        if(head == null) return true;
        if(node == null) return false;
        if(head.val != node.val) return false;
        return dfs( head.next,  node.left) || dfs( head.next,  node.right);
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null) return false;
        if(root.val == head.val){
            if(dfs(head,root)){
                return true;
            }
        }
        return isSubPath( head,  root.left) || isSubPath( head,  root.right);
    }
}
