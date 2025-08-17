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
        return build(preorder,0,preorder.length-1);
    }
    public TreeNode build(int[] pre,int s,int e){
        if(s>e){
            return null;
        }
        if(s==e){
            return new TreeNode(pre[s]);
        }
        TreeNode root=new TreeNode(pre[s]);
        int idx=find(pre,s+1,e,pre[s]);
        if(idx==-1){
            root.left=build(pre,s+1,e);
            root.right=null;
        }else{
            root.left=build(pre,s+1,idx-1);
            root.right=build(pre,idx,e);
        }
        
        
        return root;
    }
    public int find(int[] pre,int s,int e,int r){
        for(int i=s;i<=e;i++){
            if(pre[i]>r){
                return i;
            }
        }
        return -1;

    }
}