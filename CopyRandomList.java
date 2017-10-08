package brian;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by brian on 9/27/17.
 */
public class CopyRandomList {
    class RandomListNode {
       int label;
       RandomListNode next, random;
       RandomListNode(int x) { label = x; }
    }

    public RandomListNode copyRandomListByMap(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummyHead = new RandomListNode(0);
        RandomListNode p = head;
        RandomListNode q = dummyHead;
        while (p != null) {
            q.next = new RandomListNode(p.label);
            map.put(p, q.next);
            p = p.next;
            q = q.next;
        }
        p = head;
        q = dummyHead;
        while (p != null) {
            q.next.random = map.get(p.random);
            p = p.next;
            q = q.next;
        }
        return dummyHead.next;
    }

    public RandomListNode copyRandomListByNewStructure(RandomListNode head) {
        RandomListNode p = head;
        while (p != null) {
            RandomListNode next = p.next;
            RandomListNode copy = new RandomListNode(p.label);
            p.next = copy;
            copy.next = next;
            p = next;
        }
        p = head;
        while (p != null) {
            p.next.random = (p.random != null) ? p.random.next : null;
            p = p.next.next;
        }
        p = head;
        RandomListNode copyHead = (p != null) ? p.next : null;
        while (p != null) {
            RandomListNode copy = p.next;
            p.next = copy.next;
            p = p.next;
            copy.next = (p != null) ? p.next : null;
        }
        return copyHead;
    }
}
