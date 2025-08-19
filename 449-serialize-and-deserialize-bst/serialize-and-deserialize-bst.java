/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        pre(root,sb);
        return sb.toString();
    }
    private void pre(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("null,");
            return;
        }

        sb.append(root.val).append(",");
        pre(root.left,sb);
        pre(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null||data.isEmpty()){
            return null;
        }
        String[] ar=data.split(",");
        return build(ar);
    }
    int idx=0;
    private TreeNode build(String[] ar){
        if(idx>=ar.length){
            return null;
        }
        String s=ar[idx++];
        if(s.equals("null")){
            return null;
        }
        TreeNode nn=new TreeNode(Integer.parseInt(s));
        nn.left=build(ar);
        nn.right=build(ar);
        return nn;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;