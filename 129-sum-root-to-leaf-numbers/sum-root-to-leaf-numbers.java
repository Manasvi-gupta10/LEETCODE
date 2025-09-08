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
    public int sumNumbers(TreeNode root) {
        return sum(root,0);
    }
    public int sum(TreeNode root,int s){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            s=s*10+root.val;
            return s;

        }
        int l=sum(root.left,10*s+root.val);
        int r=sum(root.right,10*s+root.val);
        return l+r;
    }
}