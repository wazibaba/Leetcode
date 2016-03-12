/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    //1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 
    //[0, 1]  -> [1], however, mine output is [1,1]
    public void deleteNode(ListNode node) {
        if(node == null) return;
        ListNode curr = node;
        ListNode prev = node;
        while(curr.next != null)
        {
            curr.val = curr.next.val;
            prev = curr;
            curr = curr.next;
        }
        curr = null;
        prev.next = null;
    }
}