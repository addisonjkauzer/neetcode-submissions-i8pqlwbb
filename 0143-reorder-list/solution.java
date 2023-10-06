/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {

        ListNode current = head;

        while (current.next != null) {
            current.next = reverseLinkedList(current.next);
            current = current.next;
        }

    }

    private ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = null;
        ListNode second = head;
        ListNode third = head.next;

        while (third != null) {
            second.next = first;
            first = second;
            second = third;
            third = second.next;
        }
        second.next = first;

        return second;
    }

}