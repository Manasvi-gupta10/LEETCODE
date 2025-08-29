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
    public int maxAncestorDiff(TreeNode root) {
        return mindif(root).ans;
    }
    public pair mindif(TreeNode root){
        if(root==null){
            return new pair();
        }
         if (root.left == null && root.right == null) {
            return new pair(root.val, root.val, 0);
        }
        pair l=mindif(root.left);
        pair r=mindif(root.right);
        pair s=new pair();
        s.min=Math.min(root.val,Math.min(l.min,r.min));
        s.max=Math.max(root.val,Math.max(l.max,r.max));
        int an=Math.max(Math.abs(root.val-Math.min(l.min,r.min)),Math.abs(root.val-Math.max(l.max,r.max)));
        s.ans=Math.max(an,Math.max(l.ans,r.ans));
        return s;
    }
    class pair{
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int ans=0;
        public pair(){

        }
         public pair(int min, int max, int ans) {
            this.min = min;
            this.max = max;
            this.ans = ans;
        }
       
        
    }
}