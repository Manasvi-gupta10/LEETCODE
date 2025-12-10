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
    public int[] findMode(TreeNode root) {
        HashMap<Integer,Integer> map=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        int fr=0;
        q.add(root);
        while(!q.isEmpty()){
            TreeNode t=q.poll();
            map.put(t.val,map.getOrDefault(t.val,0)+1);
            fr=Math.max(fr,map.get(t.val));
            if(t.left!=null){
                q.add(t.left);
            }
            if(t.right!=null){
                q.add(t.right);
            }

        }
        HashSet<Integer> set=new HashSet<>();
        for(int k:map.keySet()){
            if(map.get(k)==fr){
                set.add(k);
            }
        }
        int[] ans=new int[set.size()];
        int in=0;
        for(int i:set){
            ans[in++]=i;
        }
        return ans;

        
    }
}