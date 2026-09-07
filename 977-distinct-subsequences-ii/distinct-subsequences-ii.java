class Solution {
    public int distinctSubseqII(String s) {
        long MOD = 1000000007;
        long dp = 1;
        long[] last = new long[26];

        for (char c : s.toCharArray()) {
            int i = c - 'a';

            long newDp = (2 * dp - last[i] + MOD) % MOD;

            last[i] = dp;
            dp = newDp;
        }

        return (int) ((dp - 1 + MOD) % MOD);
    }
}

