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
        ListNode current = head;
        int l=0;
        while(current != null){
            l++;
            current = current.next;
        }
        int num = (int)Math.floor(l/k);
        ListNode dummy= new ListNode(0) ;
        dummy.next = head;
        ListNode prv = dummy;
        // d -> 1      -> 2 -> 3 -> 4 -> 5 -> 6
        // prv  newNext        next
        // d -> 3 -> 2     -> 1 -> 4
        // prv                new       next

        ListNode next;
        ListNode newNext;
        for(int i=0;i< num ;i++){
            newNext = prv.next;
            for(int j=1; j<k ;j++){
                next = newNext.next.next;
                newNext.next.next = prv.next; //3 -> 2
               
                prv.next = newNext.next; // d -> 3
                newNext.next = next; //1-> 4
            }
            prv = newNext ;

        }
        return dummy.next;
    }
}