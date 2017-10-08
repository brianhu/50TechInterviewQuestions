package brian;

/**
 * Created by brian on 9/17/17.
 */
public class SwapNodesInPairs {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode current = dummyHead, p = head;
        while (p != null && p.next != null) {
            ListNode q = p.next, r = p.next.next;
            current.next = q;
            q.next = p;
            p.next = r;
            current = p;
            p = r;
        }
        return dummyHead.next;
    }
}
