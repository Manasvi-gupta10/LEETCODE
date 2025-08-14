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

int idx=0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        build(root,sb);
        return sb.toString();

        
    }
    private void build(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("null,");
            return;
        }

        sb.append(root.val).append(",");
        build(root.left,sb);
        build(root.right,sb);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null||data.isEmpty()){
            return null;
        }
        String[] ar=data.split(",");
        return parse(ar);

        
    }
    public TreeNode parse(String[] ar){
        if(idx>=ar.length){
            return null;
        }
        String s=ar[idx++];
        if(s.equals("null")){
            return null;
        }
        TreeNode node=new TreeNode(Integer.parseInt(s));
        node.left=parse(ar);
        node.right=parse(ar);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));