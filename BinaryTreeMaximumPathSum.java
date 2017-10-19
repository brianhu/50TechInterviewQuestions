package brian;

/**
 * Created by brian on 10/19/17.
 */
public class BinaryTreeMaximumPathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMax(root);
        return maxSum;
    }

    private int findMax(TreeNode n) {
        if (n == null) return 0;
        int left = findMax(n.left);
        int right = findMax(n.right);
        maxSum = Math.max(n.val + left + right, maxSum);
        int result = n.val + Math.max(left, right);
        return result > 0 ? result : 0;
    }
}
