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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        ListNode prev = head;
        if(head == null){
            return null;
        }
        while(curr.next != null){
            
            if(curr.val != curr.next.val){
                prev = curr;
                curr = curr.next;
            }else{
                ListNode lastDup = curr.next;
                while(lastDup.next != null && curr.val == lastDup.next.val){
                    lastDup = lastDup.next;
                }
                if(curr == head){
                    if(lastDup.next == null){
                        return null;
                    }
                    head = lastDup.next;
                    curr = head;
                }else{
                    if(lastDup.next != null){
                        prev.next = lastDup.next;
                        curr = prev.next;
                    }else{
                        prev.next = null;
                        break;
                    }
                }
                
                
            }
            
        }

        return head;
    }
}