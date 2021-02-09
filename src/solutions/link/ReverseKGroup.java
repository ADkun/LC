package solutions.link;

import linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;

        ListNode curr = head; // 用以当前组的指针
        ListNode nextHead = null; // 指向下一组第一个节点的指针
        ListNode newHead = null; // 本组的新头节点指针
        List<ListNode> list = new ArrayList<>();
        for (int i = 0; i < k; ++i) { // 先将本组节点加入list
            if (curr == null) break;
            else {
                list.add(curr);
                curr = curr.next;
            }
        }
        int listSize = list.size();
        if (listSize < k) { // 若本组小于k个节点，则返回第一个节点
            newHead = list.get(0);
        } else { // 若本组有k个节点，则反转本组，并将本组第一个节点连接下一组的头节点（递归）
            newHead = list.get(k - 1);
            nextHead = newHead.next;
            for (int i = 0; i < k - 1; ++i) {
                list.get(i + 1).next = list.get(i);
            }
            list.get(0).next = reverseKGroup(nextHead, k);
        }
        return newHead;
    }
}
