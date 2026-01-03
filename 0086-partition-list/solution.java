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
    public ListNode partition(ListNode head, int x) {
        ListNode headLessThan = new ListNode();
        ListNode tailLessThan = headLessThan;
        ListNode headGreaterThan = new ListNode();
        ListNode tailGreaterThan = headGreaterThan;

        while (head != null) {
            ListNode nextNode = head.next;
            if (head.val < x) {
                tailLessThan.next = head;
                tailLessThan = tailLessThan.next;
            } else {
                tailGreaterThan.next = head;
                tailGreaterThan = tailGreaterThan.next;
            }
            head = nextNode;
        }
        headGreaterThan = headGreaterThan.next;
        tailLessThan.next = headGreaterThan;
        tailGreaterThan.next = null;
        return headLessThan.next;
    }
}