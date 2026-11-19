
class Solution {
    public boolean isMatch(String s, String p) {

        // Get the lengths of the input string and pattern
        int m = s.length();
        int n = p.length();

        // Create a DP table to store matching results
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Empty string matches an empty pattern
        dp[0][0] = true;

        // Handle patterns like a*, a*b*, a*b*c*
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // Check every possible substring and pattern prefix
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                // Check if current characters match
                if (p.charAt(j - 1) == '.' ||
                    p.charAt(j - 1) == s.charAt(i - 1)) {

                    // Characters match, use previous DP result
                    dp[i][j] = dp[i - 1][j - 1];

                }

                // If current pattern character is *
                else if (p.charAt(j - 1) == '*') {

                    // Case 1: Use * zero times
                    dp[i][j] = dp[i][j - 2];

                    // Case 2: Use * one or more times
                    if (p.charAt(j - 2) == '.' ||
                        p.charAt(j - 2) == s.charAt(i - 1)) {

                        dp[i][j] = dp[i][j] ||
                                   dp[i - 1][j];
                    }
                }
            }
        }

        // Return whether the entire string matches the pattern
        return dp[m][n];
    }
}
