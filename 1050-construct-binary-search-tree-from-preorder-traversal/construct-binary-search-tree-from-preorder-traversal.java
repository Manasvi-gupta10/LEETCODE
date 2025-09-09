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
    public TreeNode bstFromPreorder(int[] preorder) {
        return order(preorder,0,preorder.length-1);
    }
    public TreeNode order(int[] pre,int s,int e){
        
        if(s==e){
            return new TreeNode(pre[s]);
        }
        if(s>e){
            return null;
        }
        TreeNode node=new TreeNode(pre[s]);
        int idx=find(pre,s+1,e,pre[s]);
        if(idx==-1){
            node.left=null;
            node.right=order(pre,s+1,e);
        }
       else{
         node.left=order(pre,s+1,idx);
        node.right=order(pre,idx+1,e);
       }
        return node;

    }
    public int find(int[] pre,int s,int e,int el){
        int idx=-1;
        for(int i=s;i<=e;i++){
            if(pre[i]<el){
                idx=i;
            }
        }
        return idx;
    }
}