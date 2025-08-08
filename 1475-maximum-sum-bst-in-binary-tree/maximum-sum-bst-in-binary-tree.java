
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
    public int maxSumBST(TreeNode root) {
        return valid(root).ans;
    }
    public bstpair valid(TreeNode root){
        if(root==null){
            return new bstpair();
        }
        bstpair left=valid(root.left);
        bstpair right=valid(root.right);
        bstpair rt=new bstpair();
        
        if(left.mx<root.val&&root.val<right.mn&&left.isbst&&right.isbst){
            rt.isbst=true;
        }else{
            rt.isbst=false;
        }
        rt.mx=Math.max(root.val,Math.max(left.mx,right.mx));
        rt.mn=Math.min(root.val,Math.min(left.mn,right.mn));
        rt.sum=left.sum+right.sum+root.val;
        if(rt.isbst){
            rt.ans=Math.max(left.ans,Math.max(right.ans,rt.sum));
        }else{
            rt.ans=Math.max(left.ans,right.ans);
        }
        return rt;


    }
    class bstpair{
        //lomg m as constraints m int ki max and min toh logg as normally bst m duplicate n hote
        long mx=Long.MIN_VALUE;
        long mn=Long.MAX_VALUE;
        boolean isbst=true;
        int sum=0;//root se neche tk ka tree ka sum
        int ans=0;//bst part sum
    }
}