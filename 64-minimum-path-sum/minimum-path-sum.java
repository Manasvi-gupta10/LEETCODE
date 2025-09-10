class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return pp(grid, 0, 0,dp);
    }

    public int pp(int[][] grid, int cr, int cc , int[][] dp) {
        int r = grid.length, c = grid[0].length;
        if (cr >= r || cc >= c) return Integer.MAX_VALUE; 
        if (cr == r - 1 && cc == c - 1) return grid[cr][cc]; 

        if (dp[cr][cc] != -1) {
            return dp[cr][cc];
        }

        int down = pp(grid, cr + 1, cc,dp);
        int right = pp(grid, cr, cc + 1,dp);

        return dp[cr][cc] = grid[cr][cc] + Math.min(down, right);
    }
}