
class Solution {
    public int removeElement(int[] nums, int val) {

        // Step 1: Create a pointer i.
        // It represents the position where the next
        // element (which is not equal to val) should be placed.
        int i = 0;

        // Step 2: Traverse the entire array using j.
        for (int j = 0; j < nums.length; j++) {

            // Step 3: Check whether the current element
            // is different from the value we want to remove.
            if (nums[j] != val) {

                // Step 4: Copy the valid element to position i.
                nums[i] = nums[j];

                // Move i to the next available position.
                i++;
            }
        }

        // Step 5: Return the number of elements
        // that are not equal to val.
        return i;
    }
}
