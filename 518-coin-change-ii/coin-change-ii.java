class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[amount+1][n+1];
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=1;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int in=0,ex=0;
                if(coins[j-1]<=i){
                    in=dp[i-coins[j-1]][j];
                }
                ex=dp[i][j-1];
                dp[i][j]=in+ex;
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}