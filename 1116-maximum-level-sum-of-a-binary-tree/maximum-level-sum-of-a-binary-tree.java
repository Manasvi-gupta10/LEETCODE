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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        int level=1;
        int sum=Integer.MIN_VALUE;
        int ans=0;
        q.add(root);
        while(!q.isEmpty()){
            int s=q.size();
            int a=0;
            for(int i=0;i<s;i++){
                TreeNode r=q.poll();
                a+=r.val;
                if(r.left!=null){
                    q.add(r.left);

                }if(r.right!=null){
                    q.add(r.right);
                }
            }
           if(sum!=a){
             sum=Math.max(sum,a);
            if(sum==a){
                ans=level;
            }
           }
            level++;
        }
        return ans;
    }
}