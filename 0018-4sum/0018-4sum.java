import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        // Store all unique quadruplets
        List<List<Integer>> result = new ArrayList<>();

        // Sort the array to use the two-pointer approach
        Arrays.sort(nums);

        int n = nums.length;

        // First loop selects the first number
        for (int i = 0; i < n - 3; i++) {

            // Skip duplicate first numbers
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Second loop selects the second number
            for (int j = i + 1; j < n - 2; j++) {

                // Skip duplicate second numbers
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // Two pointers for the remaining two numbers
                int left = j + 1;
                int right = n - 1;

                // Search for the remaining two numbers
                while (left < right) {

                    // Use long to avoid integer overflow
                    long sum = (long) nums[i] + nums[j]
                             + nums[left] + nums[right];

                    // If sum equals target, store the quadruplet
                    if (sum == target) {

                        result.add(Arrays.asList(
                            nums[i], nums[j], nums[left], nums[right]
                        ));

                        // Move both pointers
                        left++;
                        right--;

                        // Skip duplicate third numbers
                        while (left < right &&
                               nums[left] == nums[left - 1]) {
                            left++;
                        }

                        // Skip duplicate fourth numbers
                        while (left < right &&
                               nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }

                    // If sum is smaller, increase the sum
                    else if (sum < target) {
                        left++;
                    }

                    // If sum is greater, decrease the sum
                    else {
                        right--;
                    }
                }
            }
        }

        // Return all unique quadruplets
        return result;
    }
}