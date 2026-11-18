class Solution {
    public String digitSum(String s, int k) {

        // Keep performing rounds while the string length is greater than k
        while (s.length() > k) {

            // StringBuilder is used to build the new string efficiently
            StringBuilder result = new StringBuilder();

            // Divide the string into groups of size k
            for (int i = 0; i < s.length(); i += k) {

                // Store the sum of digits in the current group
                int sum = 0;

                // Find the ending index of the current group
                // Math.min ensures the last group doesn't go beyond the string
                int end = Math.min(i + k, s.length());

                // Visit each character in the current group
                for (int j = i; j < end; j++) {

                    // Convert the character digit into an integer and add it
                    sum += s.charAt(j) - '0';
                }

                // Convert the sum into a string and append it to result
                result.append(sum);
            }

            // Replace the old string with the newly created string
            s = result.toString();
        }

        // Return the string when its length is k or less
        return s;
    }
}