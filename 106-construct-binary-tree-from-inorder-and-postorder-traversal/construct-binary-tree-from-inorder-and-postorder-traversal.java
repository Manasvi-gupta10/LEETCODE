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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder,inorder,0,inorder.length-1,0,postorder.length-1);
    }
    public TreeNode build(int[] post,int[] in,int ilo,int ihi,int plo,int phi){
        if(ilo>ihi||plo>phi){
            return null;
        }

        TreeNode root=new TreeNode(post[phi]);
        int idx=search(in,ilo,ihi,post[phi]);
        int c=idx-ilo;
        root.left=build(post,in,ilo,idx-1,plo,plo+c-1);
        root.right=build(post,in,idx+1,ihi,plo+c,phi-1);
        return root;
    }
    public int search(int[] in,int ilo,int ihi,int elm){
        for(int i=ilo;i<=ihi;i++){
            if(in[i]==elm){
                return i;
            }
        }
        return -1;
    }
}