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
        TreeNode root=tree(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
        return root;
    }
    public TreeNode tree(int[] in,int[] post,int ilo,int ihi,int plo,int phi){
        if(ilo>ihi||plo>phi){
            return null;
        }
        TreeNode nn=new TreeNode(post[phi]);
        int idx=find(in,ilo,ihi,post[phi]);
        int c=idx-ilo-1;
        nn.left=tree(in,post,ilo,idx-1,plo,plo+c);
        nn.right=tree(in,post,idx+1,ihi,plo+c+1,phi-1);
        return nn;

    }
    public int find(int[] in,int ilo,int ihi,int e){
        for(int i=ilo;i<=ihi;i++){
            if(in[i]==e){
                return i;
            }
        }
        return -1;
    }
}