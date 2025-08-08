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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q=new LinkedList<>();
        ArrayList<Long> ls=new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            int s=q.size();
            long sum=0;
            for(int i=1;i<=s;i++){
                TreeNode r=q.poll();
                sum+=r.val;
                if(r.left!=null){
                    q.add(r.left);
                }
                if(r.right!=null){
                    q.add(r.right);
                }
            }
            System.out.println(sum);
            ls.add(sum);
        }
        Collections.sort(ls);
        System.out.println(ls);
        if(ls.size()<k){
            return -1;
        }
        return ls.get(ls.size()-k);
    }
}