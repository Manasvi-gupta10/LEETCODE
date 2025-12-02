/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return root;
        }
        if(root==p||root==q){
            return root;
        }
        TreeNode la=lowestCommonAncestor(root.left,p,q);
        TreeNode ra=lowestCommonAncestor(root.right,p,q);
        if(la!=null&&ra!=null){
            return root;
        }
        else if(la==null){
            return ra;
        }
        else{
            return la;
        }
    }
}