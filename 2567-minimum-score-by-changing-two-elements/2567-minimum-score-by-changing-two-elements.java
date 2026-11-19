import java.util.Arrays;

class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;

        // If there are 3 or fewer elements, the score can be 0
        if (n <= 3) {
            return 0;
        }

        // Sort the array
        Arrays.sort(nums);

        // Try the 3 possible ways to change 2 elements
        int case1 = nums[n - 1] - nums[2]; // Change 2 smallest
        int case2 = nums[n - 2] - nums[1]; // Change smallest and largest
        int case3 = nums[n - 3] - nums[0]; // Change 2 largest

        // Return the minimum possible score
        return Math.min(case1, Math.min(case2, case3));
    }
}