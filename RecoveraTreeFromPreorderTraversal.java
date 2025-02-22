// dfs recursion

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
    int index=0;
    int n=0;
    public TreeNode recoverFromPreorder(String traversal) {
        n = traversal.length();
        return recur(traversal,0);
    }
    public TreeNode recur(String traversal, int depth){
        if(index >= n) return null;
        //count the dash
        int count=0;
        int tempI=index;
        while(tempI < n && !Character.isDigit(traversal.charAt(tempI))){
            count++;
            tempI++;
        }
        if(count!=depth) return null;
        index = tempI;
        //find the number
        int val=0;
        while(index < n && Character.isDigit(traversal.charAt(index))){
            val = val * 10 + (traversal.charAt(index) - '0');
            index++;
        }
        TreeNode node = new TreeNode(val);
        node.left = recur(traversal, depth+1);
        node.right = recur(traversal, depth+1);
        return node;
    }

}











// iterative stack
class Solution {
    int index=0;
    int n=0;
    public TreeNode recoverFromPreorder(String traversal) {
        n = traversal.length();
        return recur(traversal);
    }
    public TreeNode recur(String traversal){
        Stack<TreeNode> stack = new Stack<>();
        // if(index >= n) return null;
        while(index < n){
             //count the dash
            int count=0;
            while(index < n && !Character.isDigit(traversal.charAt(index))){
                count++;
                index++;
            }
            int depth = stack.size();
            while(depth > count){
                stack.pop();
                depth--;
            }

            //find the number
            int val=0;
            while(index < n && Character.isDigit(traversal.charAt(index))){
                val = val * 10 + (traversal.charAt(index) - '0');
                index++;
            }

            TreeNode node = new TreeNode(val);
            if(!stack.isEmpty()){
                if(stack.peek().left == null){
                    stack.peek().left = node;
                }else{
                    stack.peek().right = node;
                }
            }
            stack.push(node);

        }
       
        while(stack.size()>1){
            stack.pop();
        }
        return stack.peek();
    }

}
