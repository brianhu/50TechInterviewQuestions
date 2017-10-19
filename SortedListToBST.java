package brian;

/**
 * Created by brian on 10/15/17.
 */
public class SortedListToBST {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private ListNode currentNode;

    public TreeNode sortedListToBST(ListNode head) {
        int lengthOfList = 0;
        ListNode n = head;
        while (n != null) {
            n = n.next;
            lengthOfList++;
        }
        currentNode = head;
        return sortedListToBST(0, lengthOfList - 1);
    }

    private TreeNode sortedListToBST(int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode leftChild = sortedListToBST(start, mid - 1);
        TreeNode treeNode = new TreeNode(currentNode.val);
        treeNode.left = leftChild;
        currentNode = currentNode.next;
        treeNode.right = sortedListToBST(mid + 1, end);
        return treeNode;
    }
}
