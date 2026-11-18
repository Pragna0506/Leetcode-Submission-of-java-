class Solution {
    public int numOfSubarrays(int[] arr) {

        // Required modulo value
        int MOD = 1000000007;

        // Count of prefix sums that are even and odd
        // Initially, prefix sum = 0, which is even
        int even = 1;
        int odd = 0;

        // Stores the running prefix sum
        int prefixSum = 0;

        // Stores the answer
        int count = 0;

        // Traverse every element in the array
        for (int num : arr) {

            // Add the current number to the prefix sum
            prefixSum += num;

            // Check whether the prefix sum is odd or even
            if (prefixSum % 2 == 0) {

                // Current prefix is even
                // Odd subarrays are formed using previous odd prefixes
                count = (count + odd) % MOD;

                // Store this even prefix
                even++;

            } else {

                // Current prefix is odd
                // Odd subarrays are formed using previous even prefixes
                count = (count + even) % MOD;

                // Store this odd prefix
                odd++;
            }
        }

        // Return the number of odd-sum subarrays
        return count;
    }
}