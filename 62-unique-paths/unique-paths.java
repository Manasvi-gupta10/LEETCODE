class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        return path(m,n,0,0,dp);
    }
    public int path(int m,int n,int r,int c,int[][] dp){
        if(r>=m||c>=n){
            return 0;
        }
        if(r==m-1&&c==n-1){
            return 1;
        }
        if(dp[r][c]!=0){
            return dp[r][c];
        }
        int w1=path(m,n,r+1,c,dp);
        int w2=path(m,n,r,c+1,dp);
        return dp[r][c]=w1+w2;
    }
}