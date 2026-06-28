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

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1) {
            return head;
        }

        // Dummy node before head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Node before current group
        ListNode groupPrev = dummy;

        while (true) {

            // Step 1: Find kth node
            ListNode kth = groupPrev;

            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }

            // Less than k nodes left
            if (kth == null) {
                break;
            }

            // Step 2: Save next group's starting node
            ListNode groupNext = kth.next;

            // Step 3: Reverse current group
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Step 4: Connect reversed group
            ListNode temp = groupPrev.next; // old first node (now tail)

            groupPrev.next = kth;
            groupPrev = temp; // move to tail for next iteration
        }

        return dummy.next;
    }
}