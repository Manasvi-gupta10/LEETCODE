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
    public TreeNode constructFromPrePost(int[] preorder,int[] postorder) {
        return build(preorder,0,preorder.length-1,postorder,0,postorder.length-1);
    }
    public TreeNode build(int[] pr,int prl,int prh,int[] post,int pol,int poh){
        if(prl>prh){
            return null;
        }

        TreeNode nn=new TreeNode(pr[prl]);
        if(prl==prh){
            return nn;
        }
        int idx=find(post,pol,poh,pr[prl+1]);
        int c=idx-pol+1;
        nn.left=build(pr,prl+1,prl+c,post,pol,idx);
        nn.right=build(pr,prl+c+1,prh,post,idx+1,poh);
        return nn;



    }
    public int find(int[] post,int pol,int poh,int e){
        int idx=0;
        for(int i=pol;i<=poh;i++){
            if(post[i]==e){
                return i;
            }
        }
        return idx;
    }
}