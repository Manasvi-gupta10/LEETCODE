
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
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if(root==null){
            return null;

        }
        if(root.left==null&&root.right==null){
            limit-=root.val;
            if(limit>0){
                return null;
            }
            return root;
        }
        root.left=sufficientSubset(root.left,limit-root.val);
        root.right=sufficientSubset(root.right,limit-root.val);
        //sum less hua toh delete toh ab dono gye kyuki wo utna sum ni kr parhe the isisliye us node se bhi sum limit jitna ni ho payega
        if(root.left==null&&root.right==null){
            return null;
        }
        return root;
    }
   
    
}