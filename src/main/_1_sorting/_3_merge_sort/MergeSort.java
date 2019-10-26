package _1_sorting._3_merge_sort;


import utils.ListNode;

/* *
 * Implementation of Merge Sort, using the idea of Divide and Conquer (see more in package #12)
 * Time complexity = O(N*Log(N))
 *
 * LeetCode #148
 */
public class MergeSort {

    public static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = slow;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;

        ListNode leftSide = mergeSort(head);
        ListNode rightSide = mergeSort(slow);
        return merge(leftSide, rightSide);
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(0);
        ListNode current = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        current.next = l1 == null ? l2 : l1;
        return prehead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        int[] array = new int[] {5, 9 ,2 ,7, 4, 5, 8, -1, 0, 0};
        for (int n : array) {
            curr.next = new ListNode(n);
            curr = curr.next;
        }

        ListNode newHead = mergeSort(head.next);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
        System.out.println();
    }
}
