class Solution {
    
    public List<String> binaryTreePaths(TreeNode root) 
    {
        ArrayList<String> list = new ArrayList<>();
        if(root==null) return list;
        paths(root,"",list);
        return list;
    }
    
    public static boolean paths(TreeNode root,String S, ArrayList<String> list)
    {
        if(root.left==null && root.right==null)
        {
             list.add(S+root.val);
            return true; 
        }
        if(root.left!=null) paths(root.left,S+root.val+"->",list);
        if(root.right!=null) paths(root.right,S+root.val+"->",list);
        return true;
    }
}
