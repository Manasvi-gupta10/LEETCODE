
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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        ArrayList<Integer> ls=new ArrayList<>();
        while(!q.isEmpty()){
            int sz=q.size();
            int s=0;
            for(int i=0;i<sz;i++){
                TreeNode rem=q.poll();
                s+=rem.val;
                if(rem.left!=null){
                    q.add(rem.left);
                }
                if(rem.right!=null){
                    q.add(rem.right);
                }
            }
            ls.add(s);
        }
        
        return ls.get(ls.size()-1);
    }
}