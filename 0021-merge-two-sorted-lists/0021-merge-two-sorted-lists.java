
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Step 1: Create a dummy node.
        // It acts as the starting point of the merged list.
        // Dummy node makes it easy to build the new list.
        ListNode dummy = new ListNode(-1);

        // Step 2: Create a current pointer.
        // It helps us attach nodes to the merged list.
        ListNode current = dummy;

        // Step 3: Traverse both linked lists.
        // Continue until one of the lists becomes empty.
        while (list1 != null && list2 != null) {

            // Step 4: Compare the values of both nodes.
            if (list1.val <= list2.val) {

                // If list1 has the smaller value,
                // attach that node to the merged list.
                current.next = list1;

                // Move list1 to its next node.
                list1 = list1.next;

            } else {

                // If list2 has the smaller value,
                // attach that node to the merged list.
                current.next = list2;

                // Move list2 to its next node.
                list2 = list2.next;
            }

            // Move current to the newly attached node.
            current = current.next;
        }

        // Step 5: Attach the remaining nodes.
        // One list may still contain elements.
        // Since both lists are already sorted,
        // we can directly attach the remaining list.
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // Step 6: Return the merged list.
        // dummy.next is the actual head.
        // We don't return dummy because it is an extra node.
        return dummy.next;
    }
}
