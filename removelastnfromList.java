/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    //n = 3;  (1,3), (2,4),(3,5)
    //Given linked list: 1->2->3->4->5, and n = 2.
    //After removing the second node from the end, the linked list becomes 1->2->3->5.
    //two pointers, first one k ahead of second one;
    // k = 2; (1,2),(2,3),(3,4),(4,5)  5 - 4 = 1;
    //first=head;  second=head; (k-1) = 1  for(int i = 1; i <= n-1; i++)
    
    //what if n == 5, first =head; second 5(end), then remove the head,
    //[1,2]
    //1
    //1->2->3->4->5, and n = 2.
    public ListNode removeNthFromEnd (ListNode head, int n) {
        if(head == null) return null; if(n == 0) return head;
        ListNode slow = head; ListNode fast = head.next;
        for(int i = 1; i <= n-1; i++)
            fast = fast.next;
        if(fast  == null)
        {
            head = head.next;
            return head;
        }
        while(fast.next != null) {slow = slow.next; fast = fast.next;}
        slow.next = slow.next.next;
        return head;
    }
}