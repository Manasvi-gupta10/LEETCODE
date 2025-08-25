
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
    public String smallestFromLeaf(TreeNode root) {
        ArrayList<String> ls=new ArrayList<>();
        
        smallest(root,new StringBuilder(),ls);
        Collections.sort(ls);
        return ls.get(0);
    }
    public void smallest(TreeNode root,StringBuilder ans,ArrayList<String> ls){
        if(root==null){
            return;
        }
        ans.append((char)('a' + root.val));
        if(root.left==null&&root.right==null){
            ls.add(ans.reverse().toString());
            ans.reverse();
        }else{
            smallest(root.left,ans,ls);
        smallest(root.right,ans,ls);
        }
        ans.deleteCharAt(ans.length()-1);
        
    }
}