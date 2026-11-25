import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        // Store all valid combinations
        List<List<Integer>> result = new ArrayList<>();

        // Store the current combination
        List<Integer> current = new ArrayList<>();

        // Sort the array to handle duplicate elements
        Arrays.sort(candidates);

        // Start the backtracking process
        backtrack(candidates, target, 0, current, result);

        return result;
    }

    public void backtrack(int[] candidates, int target, int start,
                          List<Integer> current,
                          List<List<Integer>> result) {

        // If target becomes 0, we found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try each candidate from the starting index
        for (int i = start; i < candidates.length; i++) {

            // Skip duplicate elements at the same recursion level
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Since the array is sorted, no need to continue
            if (candidates[i] > target) {
                break;
            }

            // Choose the current number
            current.add(candidates[i]);

            // Move to the next index because each number
            // can only be used once
            backtrack(candidates, target - candidates[i],
                      i + 1, current, result);

            // Backtrack: remove the last selected number
            current.remove(current.size() - 1);
        }
    }
}
