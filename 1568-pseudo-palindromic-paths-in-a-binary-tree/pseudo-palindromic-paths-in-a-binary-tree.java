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
    public int pseudoPalindromicPaths (TreeNode root) {
        return paths(root,new HashMap<Integer,Integer>());
    }
    public int paths(TreeNode root,HashMap<Integer,Integer> map){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
            int el=0;
            for(int k:map.keySet()){
                if(map.get(k)%2!=0){
                    el++;
                }
            }
              map.put(root.val,map.get(root.val)-1);
            if(el>1){
                return 0;
            }else{
                return 1;
            }
            
        }
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        int l=paths(root.left,map);
        int r=paths(root.right,map);
        map.put(root.val,map.get(root.val)-1);
        return l+r;
    }
    
}