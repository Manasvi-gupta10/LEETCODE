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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> ls=new ArrayList<Integer>();
        level(root,ls);
        
        return ls.get(k-1);
    }
    public void level(TreeNode root,ArrayList<Integer> ls){
        if(root==null){
            return;
        }
        level(root.left,ls);
        ls.add(root.val);
        level(root.right,ls);

    }
}