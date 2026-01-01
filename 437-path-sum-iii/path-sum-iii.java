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
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return 0;
        }
        return ans(root,targetSum,0)+pathSum(root.left,targetSum)+pathSum(root.right,targetSum);
          }
    public int ans(TreeNode root,int target,long cur){
        if(root==null){
            return 0;
        }
        int count=0;
    cur+=root.val;
        if(cur==target){
            count=1;
        }
      //  cur+=root.val;
        count+=ans(root.left,target,cur);
        // int l2=ans(root.left,target,0);
        count+=ans(root.right,target,cur);
        //int r2=ans(root.right,target,0);
        return count;//+l2+1;
    }
}