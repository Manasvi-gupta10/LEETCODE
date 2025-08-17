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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root.left==null&&root.right==null){
            return root;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int level=0;
        while(!q.isEmpty()){
            int s=q.size();
            if(level%2==0){
                ArrayList<Integer> ar=new ArrayList<>();
                ArrayList<TreeNode> ls=new ArrayList<>();
                for(int i=0;i<s;i++){
                    TreeNode rem=q.poll();
                    ls.add(rem);
                    
                    if(rem.left!=null){
                        q.add(rem.left);
                        ar.add(rem.left.val);
                    }if(rem.right!=null){
                        q.add(rem.right);
                        ar.add(rem.right.val);
                    }
                }
                if(!ar.isEmpty()){
                    Collections.reverse(ar);
                int i=0;
               
                for(int j=0;j<ls.size()&&i<ar.size();j++){
                    TreeNode cur=ls.get(j);
                    cur.left.val=ar.get(i++);
                    cur.right.val=ar.get(i++);
                    
                }
                }
            }else{
                for(int i=0;i<s;i++){
                    TreeNode rem=q.poll();
                    
                    if(rem.left!=null){
                        q.add(rem.left);
                    }if(rem.right!=null){
                        q.add(rem.right);
                    }
                }
            }
            level++;
        }
        return root;
        
    }
}