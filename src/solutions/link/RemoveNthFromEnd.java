package solutions.link;

import linkedlist.ListNode;

import java.util.HashMap;
import java.util.Map;

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode node = head;
        int i = 0;
        while (node.next != null) {
            map.put(++i, node);
            node = node.next;
        }
        map.put(++i, node);

        if (i == 1) {
            return null;
        } else if (i - n == 0) {
            head = head.next;
        } else {
            map.get(i - n).next = map.get(i - n).next.next;
        }
        return head;
    }
}
