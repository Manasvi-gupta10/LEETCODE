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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,0,inorder.length-1,0,preorder.length-1);
    }
    public TreeNode build(int[] pre,int[] in,int ilo,int ihi,int plo,int phi){
        if(ilo>ihi||plo>phi){
            return null;
        }

        TreeNode root=new TreeNode(pre[plo]);
        int idx=search(in,ilo,ihi,pre[plo]);
        int c=idx-ilo;
        root.left=build(pre,in,ilo,idx-1,plo+1,plo+c);
        root.right=build(pre,in,idx+1,ihi,plo+c+1,phi);
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