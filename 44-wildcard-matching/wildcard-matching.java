class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        return match(s, p, 0, 0, dp);
    }

    private boolean match(String s, String p, int i, int j, Boolean[][] dp) {
        // Base cases first
        if (i == s.length() && j == p.length()) return true;
        if (i == s.length()) return allstar(p, j);
        if (j == p.length()) return false;

        // Memoization check
        if (dp[i][j] != null) return dp[i][j];

        boolean ans;
        char sc = s.charAt(i);
        char pc = p.charAt(j);

        if (pc == sc || pc == '?') {
            ans = match(s, p, i + 1, j + 1, dp);
        } else if (pc == '*') {
            ans = match(s, p, i, j + 1, dp) || match(s, p, i + 1, j, dp);
        } else {
            ans = false;
        }

        return dp[i][j] = ans;
    }

    private boolean allstar(String p, int j) {
        for (int k = j; k < p.length(); k++) {
            if (p.charAt(k) != '*') return false;
        }
        return true;
    }
}
