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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if(head.next == null) {
            return head;
        }
        ListNode first = null;
        ListNode second = head;
        ListNode third = head.next;
        while (second.next != null) {
            second.next = first;
            first = second;
            second = third;
            third = second.next;
        }
        second.next = first;
        return second;
    }
}