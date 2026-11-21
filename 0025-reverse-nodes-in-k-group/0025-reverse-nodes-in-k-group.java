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

        // Step 1: Create a dummy node
        // It helps us manage the head of the linked list.
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // groupPrev points to the node before the current group.
        ListNode groupPrev = dummy;

        // Continue processing groups
        while (true) {

            // Step 2: Find the kth node of the current group.
            ListNode kth = groupPrev;

            for (int i = 0; i < k; i++) {

                // Move kth pointer k times.
                kth = kth.next;

                // If kth becomes null, fewer than k nodes remain.
                // Leave these remaining nodes unchanged.
                if (kth == null) {
                    return dummy.next;
                }
            }

            // Step 3: Save the node after the current group.
            ListNode groupNext = kth.next;

            // Step 4: Reverse the current group.

            // Start prev from groupNext.
            // This connects the reversed group to the remaining list.
            ListNode prev = groupNext;

            // Start current from the first node of the group.
            ListNode curr = groupPrev.next;

            // Reverse nodes until we reach groupNext.
            while (curr != groupNext) {

                // Save the next node before changing the link.
                ListNode temp = curr.next;

                // Reverse the current node's link.
                curr.next = prev;

                // Move prev forward.
                prev = curr;

                // Move curr to the next original node.
                curr = temp;
            }

            // Step 5: Connect the previous part to the reversed group.
            // kth is now the first node of the reversed group.
            ListNode oldGroupHead = groupPrev.next;
            groupPrev.next = kth;

            // Step 6: Move groupPrev to the end of the reversed group.
            // The old group head is now the last node.
            groupPrev = oldGroupHead;
        }
    }
}
