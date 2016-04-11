/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //Given 1->2->3->4->5->NULL, m = 2 and n = 4,  because only do 2 of these operation. 
        //return 1->4->3->2->5->NULL.
        int i;
        if(head == null) return head;
        ListNode dumb = new ListNode(0); dumb.next = head;
        ListNode prev = dumb; ListNode curr = head;
        for(i = 1; i < m; i++) {
            prev = curr;
            curr = curr.next;
        }
        ListNode oriCurr = curr;
        ListNode next = curr.next;
        if(next == null) return dumb.next;
        for(i = m; i < n; i++) {  //so here should be [m, n), then wil be n-1-m + 1 operations
            ListNode next1 = next.next;
            prev.next = next;
            next.next = curr;
            
            curr = prev.next;
            next = next1;
            if(next == null) break;
        }
        oriCurr.next = next;
        return dumb.next;
    }
}
