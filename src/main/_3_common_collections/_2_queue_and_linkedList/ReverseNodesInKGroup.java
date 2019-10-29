package _3_common_collections._2_queue_and_linkedList;

import utils.ListNode;

// #25
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode temp = head;
        for (int i = 1; i < k; i++) {
            if (temp.next == null) return head;
            temp = temp.next;
        }
        ListNode nextSection = temp.next;
        temp.next = null;
        ListNode reversedHead = reverse(head);
        head.next = reverseKGroup(nextSection, k);
        return reversedHead;
    }

    public ListNode reverse(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}
