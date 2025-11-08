class Solution {

    public int countHousePlacements(int n) {
        int[] dp = new int[n + 1];
        int ans = ways(n, dp);
        return (int)(((long) ans * ans) % 1000000007);
    }

    public int ways(int n, int[] dp) {
        if (n == 0) return 1;
        if (n == 1) return 2;

        if (dp[n] != 0) return dp[n];

        dp[n] = (int)(((long) ways(n - 1, dp) + ways(n - 2, dp)) % 1000000007);
        return dp[n];
    }
}
