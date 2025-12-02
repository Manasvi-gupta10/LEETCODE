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

        ll(root);
    }
    public TreeNode ll(TreeNode root){
        if(root==null){
            return root;
        }
        if(root.left==null&&root.right==null){
            return root;
        }
        TreeNode l=ll(root.left);
        TreeNode r=ll(root.right);
        if(l!=null){
            l.right=root.right;
            root.right=root.left;
            root.left=null;
        }
        if(r!=null){
            return r;
        }
        return l;
    }
}