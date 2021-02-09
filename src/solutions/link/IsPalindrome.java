package solutions.link;

import linkedlist.ListNode;

import java.util.*;

public class IsPalindrome {

    private ListNode frontNode;

    private boolean reverseJudge(ListNode currentNode) {
        if (currentNode != null) {
            if (!reverseJudge(currentNode.next)) return false;
            if (frontNode.val != currentNode.val) return false;
            frontNode = frontNode.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        frontNode = head;
        return reverseJudge(head);
    }

    public boolean isPalindrome2(ListNode head) {
        Deque<Integer> deque = new ArrayDeque<>();
        boolean result = true;
        ListNode node = head;
        while (node != null) {
            deque.push(node.val);
            node = node.next;
        }

        node = head;
        while (node != null) {
            if (node.val != deque.pop()) {
                result = false;
                break;
            }
            node = node.next;
        }
        return result;
    }
}
