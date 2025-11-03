class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int[][] dp=new int[n][m];
        return path(obstacleGrid,0,0,dp);
    }
    public int path(int[][] ar,int r,int c,int[][] dp){
        if(r<0||c<0||r>=ar.length||c>=ar[0].length||ar[r][c]==1){
            return 0;
        }

        if(r==ar.length-1&&c==ar[0].length-1){
            return 1;
        }
        if(dp[r][c]!=0){
            return dp[r][c];
        }
        int an=0;
        an+=path(ar,r+1,c,dp);
        an+=path(ar,r,c+1,dp);
        return dp[r][c]=an;
    }
}