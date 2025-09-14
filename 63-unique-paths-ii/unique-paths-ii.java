class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return path(obstacleGrid,dp,0,0);
    }
    public int path(int[][] mat,int[][] dp,int i,int j){
        if(i>=dp.length||j>=dp[0].length){
            return 0;
        }
        if(mat[i][j]==1){
            return 0;
        }
        if(i==dp.length-1&&j==dp[0].length-1){
            return 1;
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int d=path(mat,dp,i+1,j);
        int r=path(mat,dp,i,j+1);
        return dp[i][j]=d+r;
    }
}