class Solution {
    public String longestCommonPrefix(String[] strs) {

        // If the array is empty, return an empty string
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Take the first string as the reference
        String first = strs[0];

        // Check each character of the first string
        for (int i = 0; i < first.length(); i++) {

            // Get the current character from the first string
            char ch = first.charAt(i);

            // Compare this character with all other strings
            for (int j = 1; j < strs.length; j++) {

                // If the current string is shorter
                // or the characters do not match
                if (i >= strs[j].length() ||
                    strs[j].charAt(i) != ch) {

                    // Return the common prefix found so far
                    return first.substring(0, i);
                }
            }
        }

        // If all characters match, return the first string
        return first;
    }
}