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
        return maxsum(root).ans;
    }
    public pair maxsum(TreeNode root){
        if(root==null){
            return new pair();
        }
        pair l=maxsum(root.left);
        pair r=maxsum(root.right);
        pair self=new pair();
        if(l.mx<root.val&&r.mn>root.val&&l.isbst&&r.isbst){
            self.isbst=true;
        }else{
            self.isbst=false;
        }
        self.cur=l.cur+r.cur+root.val;
        self.mn=Math.min(root.val,Math.min(l.mn,r.mn));
        self.mx=Math.max(root.val,Math.max(l.mx,r.mx));
        if(self.isbst){
            self.ans=Math.max(self.cur,Math.max(l.ans,r.ans));
        }else{
            self.ans=Math.max(l.ans,r.ans);
        }
        return self;
    }
}
class pair{
    int mn;
    int mx;
    int ans;
    int cur;
    boolean isbst;
    public pair(){
        mn=Integer.MAX_VALUE;
        mx=Integer.MIN_VALUE;
        ans=0;
        cur=0;
        isbst=true;
    }
}