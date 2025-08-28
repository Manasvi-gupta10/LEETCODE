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
    public boolean isCompleteTree(TreeNode root) {
        Queue<pair> q=new LinkedList<>();
        ArrayList<Integer> ls=new ArrayList<>();
        q.add(new pair(0,root));
        while(!q.isEmpty()){
            pair p=q.poll();
            ls.add(p.idx);
            if(p.node.left!=null){
                q.add(new pair(2*p.idx+1,p.node.left));
            }
            if(p.node.right!=null){
                q.add(new pair(2*p.idx+2,p.node.right));
            }
        }
        int i=ls.size()-1;
        //System.out.println(ls);
        while(i>0){
            if(ls.get(i)!=ls.get(i-1)+1){
                return false;
            }
            i--;
        }
        return true;

    }
    class pair{
        int idx;
        TreeNode node;
        public pair(int idx,TreeNode node){
            this.idx=idx;
            this.node=node;
        }
    }
}