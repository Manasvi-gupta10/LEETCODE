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
    public void flatten(TreeNode root) {
        
        root=ll(root);

    }
    public TreeNode ll(TreeNode root){
        if(root==null){
            return null;
        }
        if(root.left==null&&root.right==null){
            return root;
        }
        TreeNode ltail=ll(root.left);
        TreeNode rtail=ll(root.right);
        if(root.left!=null){
            ltail.right=root.right;
            root.right=root.left;
            root.left=null;
        }
        if(rtail!=null){
            return rtail;
        }
        return ltail;
    }
}