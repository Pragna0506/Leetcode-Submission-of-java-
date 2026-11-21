
import java.util.*;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        // Step 1: Build the original tree using its children.
        List<Integer>[] children = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }

        // Step 2: Track the most recent ancestor for each character.
        int[] last = new int[26];
        Arrays.fill(last, -1);

        // Store the final parent of every node.
        int[] newParent = new int[n];

        // Store the previous matching ancestor so we can restore it
        // when DFS leaves the current node.
        int[] previous = new int[n];

        // DFS traversal order.
        int[] order = new int[n];
        int orderIndex = 0;

        // Iterative DFS avoids recursion stack overflow for n = 100000.
        int[] stackNode = new int[2 * n];
        int[] stackState = new int[2 * n];
        int top = 0;

        // State 0 = entering a node, state 1 = leaving a node.
        stackNode[top] = 0;
        stackState[top] = 0;
        top++;

        while (top > 0) {
            top--;

            int node = stackNode[top];
            int state = stackState[top];

            int ch = s.charAt(node) - 'a';

            if (state == 0) {
                // Record the node in DFS order.
                order[orderIndex++] = node;

                // Remember the closest ancestor with the same character.
                previous[node] = last[ch];

                if (node == 0) {
                    newParent[node] = -1;
                } else if (last[ch] != -1) {
                    // Matching ancestor exists: make it the new parent.
                    newParent[node] = last[ch];
                } else {
                    // No matching ancestor: keep the original parent.
                    newParent[node] = parent[node];
                }

                // Current node becomes the latest ancestor for this character.
                last[ch] = node;

                // Push the exit event.
                stackNode[top] = node;
                stackState[top] = 1;
                top++;

                // Push children in reverse order for DFS traversal.
                for (int i = children[node].size() - 1; i >= 0; i--) {
                    stackNode[top] = children[node].get(i);
                    stackState[top] = 0;
                    top++;
                }

            } else {
                // Restore the previous matching ancestor when leaving this node.
                last[ch] = previous[node];
            }
        }

        // Step 3: Calculate subtree sizes in the final tree.
        int[] answer = new int[n];
        Arrays.fill(answer, 1);

        // Process children before parents using reverse DFS order.
        for (int i = n - 1; i > 0; i--) {
            int node = order[i];

            // Add this node's subtree size to its final parent.
            answer[newParent[node]] += answer[node];
        }

        return answer;
    }
}
