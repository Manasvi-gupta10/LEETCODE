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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        ArrayList<TreeNode> ls=deepestLeaves(root);
        if(ls.size()==1){
            return ls.get(0);
        }
        TreeNode ans=lca(root,ls.get(0),ls.get(1));
        for(int i=2;i<ls.size();i++){
            ans=lca(root,ans,ls.get(i));
        }
        return ans;

    }
    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return root;
        }
        if(root==p||root==q){
            return root;
        }
        TreeNode left=lca(root.left,p,q);
        TreeNode right=lca(root.right,p,q);
        if(left!=null&&right!=null){
            return root;

        }else if(left==null){
            return right;
        }else{
            return left;
        }
    }
    public ArrayList<TreeNode> deepestLeaves(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        ArrayList<TreeNode> ls=new ArrayList<>();
        while(!q.isEmpty()){
            int sz=q.size();
            ls=new ArrayList<>();
            for(int i=0;i<sz;i++){
                TreeNode rem=q.poll();
                ls.add(rem);
                if(rem.left!=null){
                    q.add(rem.left);
                }
                if(rem.right!=null){
                    q.add(rem.right);
                }
            }
            
        }
        
        return ls;
    }
}