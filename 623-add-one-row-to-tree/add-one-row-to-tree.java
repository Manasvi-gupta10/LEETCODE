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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode tn=new TreeNode(val);
            tn.left=root;
            return tn;
        }
        int dep=1;
        Queue<TreeNode> q=new LinkedList<>();
        ArrayList<TreeNode> adds=new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()&&dep<=depth-1){
            int s=q.size();
            adds=new ArrayList<>();
            for(int i=0;i<s;i++){
                TreeNode r=q.poll();
                adds.add(r);
                if(r.left!=null){
                    q.add(r.left);
                }
                if(r.right!=null){
                    q.add(r.right);
                }
            }
            dep++;
        }
        for(int i=0;i<adds.size();i++){
            TreeNode l=adds.get(i).left;
            TreeNode r=adds.get(i).right;
            TreeNode nn1=new TreeNode(val);
            TreeNode nn2=new TreeNode(val);
            adds.get(i).left=nn1;
            nn1.left=l;
            adds.get(i).right=nn2;
            nn2.right=r;

        }
        return root;
    }
}