package brian;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by brian on 9/24/17.
 */
public class MergeKSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        int end = lists.length - 1;
        while (end > 0) {
            int begin = 0;
            while (begin < end) {
                lists[begin] = mergeTwoLists(lists[begin], lists[end]);
                begin++;
                end--;
            }
        }
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode n = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                n.next = l1;
                l1 = l1.next;
            } else {
                n.next = l2;
                l2 = l2.next;
            }
            n = n.next;
        }
        if (l1 != null) n.next = l1;
        if (l2 != null) n.next = l2;
        return dummyHead.next;
    }

    public ListNode mergeKListsByPriorityQueue(ListNode[] lists) {
        if (lists.length == 0) return null;
        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        };
        Queue<ListNode> queue = new PriorityQueue<>(lists.length, comparator);
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            if (node != null) queue.add(node);
        }
        ListNode dummyHead = new ListNode(0);
        ListNode n = dummyHead;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            n.next = node;
            n = n.next;
            if (node.next != null) queue.add(node.next);
        }
        return dummyHead.next;
    }
}
