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
    public long kthLargestLevelSum(TreeNode root, int k) {

        // BF
        // max heap
        //bfs - min heap.
        Queue<TreeNode> queue = new LinkedList<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            long sum = 0l;
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            pq.offer(sum);
            if(pq.size()>k){
                pq.poll();
            }
        }
        //-1 case
        if(pq.size()<k){
            return -1;
        }
        return pq.peek();
    }
}







