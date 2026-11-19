class Solution {
    public int maxArea(int[] height) {
//Two Pointer Variables//
        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;
//While Loop//
        while (left < right) {
//Width Calculation
            int width = right - left;
//Math.min()
            int h = Math.min(height[left], height[right]);
//Area Calculation
            int area = width * h;
//7. Math.max()
            maxArea = Math.max(maxArea, area);
//8. If-Else Condition
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}