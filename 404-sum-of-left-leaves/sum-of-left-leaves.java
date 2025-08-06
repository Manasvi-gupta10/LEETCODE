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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root.left==null&&root.right==null){
            return 0;
        }
        return left(root,true);
    }
    public int left(TreeNode root,boolean isl){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null&&isl){
            return root.val;//left leave node tbhi value retun kro
        }
        int l=left(root.left,true);
        int r=left(root.right,false);
        return l+r;
    }
}