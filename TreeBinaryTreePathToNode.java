public class Solution {
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> list = new ArrayList<>();
        if(A==null) return list;
        travel(A,B,list);
        return list;
    }
    public static boolean travel(TreeNode root, int B,ArrayList<Integer> list)
    {
        if(root==null) return false;
        
        list.add(root.val);

        if(root.val==B) return true;

        if(travel(root.left,B,list) || travel(root.right,B,list))
            return true;
        list.remove(list.size()-1); 
        return false;
    }
}
