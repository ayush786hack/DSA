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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sz=0;
        ListNode temp =head;
        while(temp!=null){
            sz++;
            temp=temp.next;
        }
        if(sz==n) return head.next;
        temp=head;
        for(int i=1;i<sz-n;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;


    }
}