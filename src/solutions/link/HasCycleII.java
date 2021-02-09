package solutions.link;

import linkedlist.ListNode;

public class HasCycleII {

    public ListNode detectCycle(ListNode head) {
        if (head == null) return head;
        ListNode fast = head;
        ListNode slow = head;

        while (true) {
            if (fast.next == null || fast.next.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode ptr = head;
                while (true) {
                    ptr = ptr.next;
                    slow = slow.next;
                    if (ptr == slow) {
                        return slow;
                    }
                }
            }
        }
    }
}
