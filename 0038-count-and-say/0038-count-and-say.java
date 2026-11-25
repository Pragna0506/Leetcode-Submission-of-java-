
class Solution {
    public String countAndSay(int n) {

        // Base case: The first element of the sequence is "1"
        String result = "1";

        // Repeat the process until we reach the nth sequence
        for (int i = 2; i <= n; i++) {

            // StringBuilder is used to construct the next string
            StringBuilder sb = new StringBuilder();

            // Start checking from the first character
            int j = 0;

            // Traverse the previous string
            while (j < result.length()) {

                // Store the current digit
                char current = result.charAt(j);

                // Count consecutive occurrences of the current digit
                int count = 0;

                while (j < result.length() &&
                       result.charAt(j) == current) {

                    count++;
                    j++;
                }

                // Append the count followed by the digit
                sb.append(count);
                sb.append(current);
            }

            // Update result with the newly generated string
            result = sb.toString();
        }

        // Return the nth sequence
        return result;
    }
}
