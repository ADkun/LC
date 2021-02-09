package solutions.link;

import linkedlist.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseList {

    public ListNode reverseList22(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null) return head;
        ListNode before = head;
        ListNode after = head.next;
        before.next = null;
        while (after != null && after.next != null) {
            ListNode next = after.next;
            after.next = before;
            before = after;
            after = next;
        }
        if (after != null) {
            after.next = before;
            return after;
        } else {
            return before;
        }
    }

    public ListNode reverseList(ListNode head) {
        Deque<ListNode> deque = new ArrayDeque<>();
        ListNode node = head;
        while (node != null) {
            deque.push(node);
            node = node.next;
        }

        ListNode dummy = new ListNode();
        ListNode now = dummy;
        while (!deque.isEmpty()) {
            ListNode anode = deque.pop();
            now.next = anode;
            now = anode;
        }
        now.next = null;
        return dummy.next;
    }
}
