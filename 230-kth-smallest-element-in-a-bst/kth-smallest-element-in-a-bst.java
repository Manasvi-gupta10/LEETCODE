
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while (true) {
            
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

           
            root = stack.pop();//jha root m leftmost node
            k--;
            if (k == 0){
                return root.val;
            }

            
            root = root.right;
        }
    }
}
