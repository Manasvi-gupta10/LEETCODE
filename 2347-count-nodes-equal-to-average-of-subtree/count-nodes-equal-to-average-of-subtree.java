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
    class pair{
        int sum=0;
        int avg=0;
        int el=0;
    }
    int count=0;
    public int averageOfSubtree(TreeNode root) {
        avgtree(root);
        return count;
    }
    public pair avgtree(TreeNode root){
        if(root==null){
            return new pair();
        }
        pair l=avgtree(root.left);
        pair r=avgtree(root.right);
        pair sf=new pair();
        sf.el=l.el+r.el+1;
        sf.sum=l.sum+r.sum+root.val;
        sf.avg=sf.sum/sf.el;
        if(sf.avg==root.val){
            count++;
        }
        return sf;
    }
}