
class Solution {
    public int removeDuplicates(int[] nums) {

        // Step 1: If the array has only one element,
        // there cannot be any duplicates.
        if (nums.length == 1) {
            return 1;
        }

        // Step 2: Create a pointer for unique elements.
        // i represents the position of the last unique element.
        int i = 0;

        // Step 3: Start checking from the second element.
        for (int j = 1; j < nums.length; j++) {

            // Step 4: Check whether the current element
            // is different from the previous unique element.
            if (nums[j] != nums[i]) {

                // Move i to the next position.
                i++;

                // Place the new unique element at position i.
                nums[i] = nums[j];
            }
        }

        // Step 5: Return the number of unique elements.
        // Index starts from 0, so add 1.
        return i + 1;
    }
}
