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
    public boolean isUnivalTree(TreeNode root) {
        return isvalid(root,root.val);
        
    }
    public boolean isvalid(TreeNode root,int value){
        if(root==null){
            return true;
        }
        boolean iseq=false;
        if(root.val==value){
            iseq=true;
        }
        boolean l=isvalid(root.left,value);
        boolean r=isvalid(root.right,value);
        return iseq&&l&&r;
    }
}