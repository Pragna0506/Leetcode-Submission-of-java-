class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node before the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Use two pointers
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer n + 1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the nth node from the end
        slow.next = slow.next.next;

        // Return the updated list
        return dummy.next;
    }
}