
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */



class Solution {
    public ListNode swapPairs(ListNode head) {

        // Step 1: Create a dummy node
        ListNode dummy = new ListNode(0);

        // Connect dummy to the original head
        dummy.next = head;

        // Previous pointer
        ListNode prev = dummy;

        // Continue while two nodes are available
        while (prev.next != null && prev.next.next != null) {

            // Store the first node
            ListNode first = prev.next;

            // Store the second node
            ListNode second = first.next;

            // IMPORTANT: Save the remaining node
            // before changing any links
            ListNode nextPair = second.next;

            // Step 2: Perform the swapping

            // Connect previous node to second
            prev.next = second;

            // Connect second node to first
            second.next = first;

            // Connect first node to the remaining list
            first.next = nextPair;

            // Move prev to the end of the swapped pair
            prev = first;
        }

        // Return the new head
        return dummy.next;
    }
}
