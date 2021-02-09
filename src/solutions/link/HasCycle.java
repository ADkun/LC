package solutions.link;

import linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {

    public boolean hasCycle(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy, slow = dummy;

        while (fast != null) {
            if (fast.next == null || fast.next.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            if (!set.contains(node)) {
                set.add(node);
            } else {
                return true;
            }
            node = node.next;
        }
        return false;
    }
}
