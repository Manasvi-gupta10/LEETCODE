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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ArrayList<Integer> ls=new ArrayList<Integer>();
        for(int i=0;i<to_delete.length;i++){
            ls.add(to_delete[i]);
        }
        ArrayList<TreeNode> ar=new ArrayList<TreeNode>();
        
        TreeNode r=del(root,ls,ar);
        if(r!=null){
            ar.add(root);
        }
        return ar;
    }
    public TreeNode del(TreeNode root,ArrayList<Integer> ls,ArrayList<TreeNode> ar){
        if(root==null){
            return null;
        }
        root.left=del(root.left,ls,ar);
        root.right=del(root.right,ls,ar);
        if(ls.contains(root.val)){
            if(root.left!=null){
                ar.add(root.left);
                
            }
            if(root.right!=null){
                ar.add(root.right);
                
            }
            return null;

        }
        return root;
        
    }
}