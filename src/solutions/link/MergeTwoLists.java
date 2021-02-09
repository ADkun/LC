package solutions.link;

import linkedlist.ListNode;

public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 暴力解法（迭代）
        ListNode dummy = new ListNode(-1, null);
        ListNode prev = dummy;
        ListNode node1 = l1, node2 = l2;

        while (node1 != null && node2 != null) {
            // Compare two nodes
            if (node1.val <= node2.val) {
                prev.next = node1;
                prev = node1;
                node1 = node1.next;
            } else {
                prev.next = node2;
                prev = node2;
                node2 = node2.next;
            }
        }

        if (node1 == null) {
            prev.next = node2;
        } else if (node2 == null) {
            prev.next = node1;
        }
        return dummy.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        //递归解法
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }else if(l1.val<=l2.val){
            l1.next=mergeTwoLists2(l1.next,l2);
            return l1;
        }else{
            l2.next=mergeTwoLists2(l2.next,l2);
            return l2;
        }
    }

}
