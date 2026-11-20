import java.util.*;

class Solution {

    public List<String> letterCombinations(String digits) {

        // If the input string is empty, return an empty list
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        // Mapping each digit to its corresponding letters
        String[] phone = {
            "", "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
        };

        // Stores all possible letter combinations
        List<String> result = new ArrayList<>();

        // StringBuilder stores the current combination
        StringBuilder current = new StringBuilder();

        // Start the backtracking process from index 0
        backtrack(digits, 0, phone, current, result);

        // Return all generated combinations
        return result;
    }

    // Recursive function to generate combinations
    private void backtrack(
        String digits,
        int index,
        String[] phone,
        StringBuilder current,
        List<String> result
    ) {

        // Base case: if all digits are processed
        if (index == digits.length()) {

            // Add the completed combination to the result
            result.add(current.toString());

            return;
        }

        // Get the current digit and convert it into an integer
        int digit = digits.charAt(index) - '0';

        // Get all letters corresponding to the current digit
        String letters = phone[digit];

        // Try every letter mapped to the current digit
        for (int i = 0; i < letters.length(); i++) {

            // Add the selected letter to the current combination
            current.append(letters.charAt(i));

            // Move to the next digit and generate further combinations
            backtrack(digits, index + 1, phone, current, result);

            // Remove the last added letter to try another possibility
            current.deleteCharAt(current.length() - 1);
        }
    }
}