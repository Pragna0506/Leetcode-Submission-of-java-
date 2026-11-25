class Solution {
    public int trap(int[] height) {

        // Two pointers: one at the beginning and one at the end
        int left = 0;
        int right = height.length - 1;

        // Maximum heights seen so far from each side
        int leftMax = 0;
        int rightMax = 0;

        // Stores the total trapped rainwater
        int water = 0;

        while (left < right) {

            // Process the left side if its height is smaller
            if (height[left] < height[right]) {

                // Update the maximum height on the left
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    // Water trapped = left maximum - current height
                    water += leftMax - height[left];
                }

                // Move left pointer forward
                left++;

            } else {

                // Update the maximum height on the right
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    // Water trapped = right maximum - current height
                    water += rightMax - height[right];
                }

                // Move right pointer backward
                right--;
            }
        }

        return water;
    }
}
