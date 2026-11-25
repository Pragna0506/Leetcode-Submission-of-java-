
class Solution {
    public int jump(int[] nums) {

        // Number of jumps required
        int jumps = 0;

        // End of the range reachable with current jumps
        int currentEnd = 0;

        // Farthest index reachable so far
        int farthest = 0;

        // No need to process the last index
        for (int i = 0; i < nums.length - 1; i++) {

            // Calculate the farthest index reachable
            farthest = Math.max(farthest, i + nums[i]);

            // If we reached the end of the current range
            if (i == currentEnd) {

                // We need one more jump
                jumps++;

                // Update the current range boundary
                currentEnd = farthest;
            }
        }

        return jumps;
    }
}
