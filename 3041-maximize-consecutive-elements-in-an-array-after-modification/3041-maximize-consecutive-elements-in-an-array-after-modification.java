
import java.util.Arrays;

class Solution {
    public int maxSelectedElements(int[] nums) {

        // Step 1: Sort the array
        // Sorting helps us process smaller numbers first.
        Arrays.sort(nums);

        // Step 2: Create a DP array
        // dp[i] = maximum length of consecutive elements
        // ending with nums[i] (without increasing it).
        // We also consider nums[i] + 1 as a possible value.
        int n = nums.length;

        int[] dp = new int[n];

        // Store the best answer for each possible ending value.
        java.util.HashMap<Integer, Integer> map =
            new java.util.HashMap<>();

        int ans = 1;

        // Step 3: Process each number
        for (int num : nums) {

            // Case 1: Do not increase the current number.
            // Extend a sequence ending at num - 1.
            int take1 = map.getOrDefault(num - 1, 0) + 1;

            // Case 2: Increase the current number by 1.
            // Extend a sequence ending at num.
            int take2 = map.getOrDefault(num, 0) + 1;

            // Update the best sequence ending at num.
            map.put(num, Math.max(
                map.getOrDefault(num, 0), take1));

            // Update the best sequence ending at num + 1.
            map.put(num + 1, Math.max(
                map.getOrDefault(num + 1, 0), take2));

            // Update the overall maximum length.
            ans = Math.max(ans, Math.max(take1, take2));
        }

        return ans;
    }
}
