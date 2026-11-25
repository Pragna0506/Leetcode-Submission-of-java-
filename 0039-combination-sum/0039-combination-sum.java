
import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        // Stores all valid combinations
        List<List<Integer>> result = new ArrayList<>();

        // Stores the current combination
        List<Integer> current = new ArrayList<>();

        // Start the backtracking process
        backtrack(candidates, target, 0, current, result);

        return result;
    }

    // Recursive backtracking function
    public void backtrack(int[] candidates, int target, int index,
                          List<Integer> current,
                          List<List<Integer>> result) {

        // If target becomes 0, we found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // If target becomes negative, this combination is invalid
        if (target < 0) {
            return;
        }

        // Explore candidates starting from the current index
        for (int i = index; i < candidates.length; i++) {

            // Choose the current number
            current.add(candidates[i]);

            // Recursive call:
            // Pass i again because the same number can be reused
            backtrack(candidates, target - candidates[i],
                      i, current, result);

            // Backtrack: remove the last chosen number
            current.remove(current.size() - 1);
        }
    }
}
