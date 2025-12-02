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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return path(root,0,targetSum);
    }
    public boolean path(TreeNode root,int sum,int target){
        if(root==null){
            return false;
        }
        if(root.left==null&&root.right==null){
            sum+=root.val;
            if(sum==target){
                return true;
            }
            
        }
        boolean l=path(root.left,sum+root.val,target);
        boolean r=path(root.right,sum+root.val,target);
        return l||r;
    }
}