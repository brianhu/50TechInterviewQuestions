package brian;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by brian on 10/10/17.
 */
public class MinimumDepthOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int minDepthDFS(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepthDFS(root.right) + 1;
        if (root.right == null) return minDepthDFS(root.left) + 1;
        return Math.min(minDepthDFS(root.left), minDepthDFS(root.right)) + 1;
    }

    public int minDepthBFS(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode rightMost = root;
        int depth = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null) break;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
            if (node == rightMost) {
                depth++;
                rightMost = (node.right != null) ? node.right : node.left;
            }
        }
        return depth;
    }
}
