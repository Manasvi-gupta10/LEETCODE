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
    public TreeNode increasingBST(TreeNode root) {
        ArrayList<Integer> ls=new ArrayList<>();
        in(root,ls);
        TreeNode an=new TreeNode();
        TreeNode ans=an;
        for(int i=0;i<ls.size();i++){
            an.right=new TreeNode(ls.get(i));
            an=an.right;
        }
        return ans.right;

        
    }
    public void in(TreeNode root,ArrayList<Integer> ls){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            ls.add(root.val);
            return;
        }

        in(root.left,ls);
        ls.add(root.val);
        in(root.right,ls);
    }
}