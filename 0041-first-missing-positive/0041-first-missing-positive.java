
class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

        // Place every number in its correct index
        // Example: 1 should be at index 0
        //          2 should be at index 1

        for (int i = 0; i < n; i++) {

            while (nums[i] >= 1 && nums[i] <= n &&
                   nums[nums[i] - 1] != nums[i]) {

                // Find the correct index of the current number
                int correctIndex = nums[i] - 1;

                // Swap the current number with the number
                // present at its correct index
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }

        // Find the first number that is not in its correct position
        for (int i = 0; i < n; i++) {

            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // If all numbers from 1 to n are present,
        // the missing number is n + 1
        return n + 1;
    }
}
