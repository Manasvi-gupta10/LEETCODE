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
    int camera=0;
    public int minCameraCover(TreeNode root) {
        int c=mincamera(root);
        if(c==-1){
            camera++;
        }
        return camera;
        
    }
    public int mincamera(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=mincamera(root.left);
        int right=mincamera(root.right);
        if(left==-1||right==-1){//is node pr camera needed
            camera++;
            return 1;//camera setup 

        }
        else if(left==1||right==1){
            return 0;//cover hojayega y node as child pr camera haii[ek pe camra dusra covered ya dono pr hi camra haii]
        }
        else{//dono child bs covrered hai toh is node ko camera chaiye
            return -1;
        }

    }
}