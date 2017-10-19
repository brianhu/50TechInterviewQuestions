package brian;

/**
 * Created by brian on 10/8/17.
 */
public class ValidateBinaryTree {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    private TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
//        return validate(root, null, null);
        return isIncreasing(root);
    }

    private boolean validate(TreeNode n, Integer low, Integer high) {
        if (n == null) return true;
        return (low == null || n.val > low) && (high == null || n.val < high)
                && validate(n.left, low, n.val)
                && validate(n.right, n.val, high);
    }

    private boolean isIncreasing(TreeNode n) {
        if (n == null) return true;
        if (isIncreasing(n.left)) {
            if (prev != null && n.val <= prev.val) return false;
            prev = n;
            return isIncreasing(n.right);
        }
        return false;
    }
}
