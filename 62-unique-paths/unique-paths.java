class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return paths(dp,0,0);
    }
    public int paths(int[][] dp,int i,int j){
        if(i>=dp.length||j>=dp[0].length){
            return 0;
        }
        if(i==dp.length-1&&j==dp[0].length-1){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int d=paths(dp,i+1,j);
        int r=paths(dp,i,j+1);
        return dp[i][j]=d+r;
    }
}