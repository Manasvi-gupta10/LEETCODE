class Solution {
    public int numWays(String s) {
        int mod = 1000000007;
        int n = s.length();

        int totalOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') totalOnes++;
        }

        if (totalOnes % 3 != 0) return 0;

        
        if (totalOnes == 0) {
            long ways = (long)(n - 1) * (n - 2) / 2;
            return (int)(ways % mod);
        }

        int k = totalOnes / 3;
        int onesCount = 0;

        long ways1 = 0; 
        long ways2 = 0; 
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                onesCount++;
            }
            if (onesCount == k) {
                ways1++;
            }
            if (onesCount == 2 * k) {
                ways2++;
            }
        }
        return (int)((ways1 * ways2) % mod);
    }
}