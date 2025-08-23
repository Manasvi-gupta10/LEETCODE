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
    public int goodNodes(TreeNode root) {
        return good(root,Integer.MIN_VALUE);

    }
    public int good(TreeNode root,int max){
        if(root==null){
            return 0;
        }
        int p=0;
        if(root.val>=max){
            p=1;
        }
        max=Math.max(max,root.val);
        int l=good(root.left,max);
        int r=good(root.right,max);
        return l+r+p;
    }
}