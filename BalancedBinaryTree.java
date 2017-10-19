package brian;

/**
 * Created by brian on 10/12/17.
 */
public class BalancedBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isBalanced(TreeNode root) {
        return customizedMaxDepth(root) != -1;
//        if (root == null) return true;
//        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1
//                && isBalanced(root.left)
//                && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root) {
        // TreeNode n = root;
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int customizedMaxDepth(TreeNode root) {
        // 算左右兩邊 subtree 高度差是否 <= 1
        // 若是， return 以該節點為 root 時，該 binary tree 的深度
        // 反之，return -1
        if (root == null) return 0;
        int leftDepth = customizedMaxDepth(root.left);
        if (leftDepth == -1) return -1;
        int rightDepth = customizedMaxDepth(root.right);
        if (rightDepth == -1) return -1;
        return (Math.abs(leftDepth - rightDepth) <= 1) ? (Math.max(leftDepth, rightDepth) + 1) : -1;
    }
}
