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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode head;
        ListNode pointer;

        int indexOfLowest = 0;
        ListNode lowest = lists[indexOfLowest];
        for(int i = 1; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            if (lowest == null) {
                lowest = lists[i];
                indexOfLowest = i;
            }
            if (lists[i].val < lowest.val) {
                lowest = lists[i];
                indexOfLowest = i;
            }
        }
        if (lists[indexOfLowest] != null) {
            lists[indexOfLowest] = lists[indexOfLowest].next;
        } else {
            return null;
        }
        head = lowest;
        pointer = head;

        while(lowest != null) {
            indexOfLowest = 0;
            lowest = lists[indexOfLowest];
            for(int i = 1; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }
                if (lowest == null) {
                    lowest = lists[i];
                    indexOfLowest = i;
                }
                if (lists[i].val < lowest.val) {
                    lowest = lists[i];
                    indexOfLowest = i;
                }
            }
            pointer.next = lowest;
            pointer = pointer.next;
            if (lists[indexOfLowest] != null) {
                lists[indexOfLowest] = lists[indexOfLowest].next;
            } else {
                break;
            }
        }
        return head;
    }
}