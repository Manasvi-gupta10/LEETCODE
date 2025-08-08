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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ls=new ArrayList<>();
        pre(ls,root);
        return ls;
    }
    public void pre(List<Integer> ls,TreeNode root){
        if(root==null){
            return;
        }
        ls.add(root.val);
        pre(ls,root.left);
        
        pre(ls,root.right);
        
    }
}