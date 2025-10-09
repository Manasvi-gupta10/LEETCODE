class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[amount+1][coins.length];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int maxc=coin(coins,amount,0,dp);
        if(maxc==Integer.MAX_VALUE){
            return -1;
        }
        return maxc;
    }
    public int coin(int[] coin,int amt,int in,int[][] dp){
        if(amt==0){
            return 0;
        }
        if(amt<0){
            return Integer.MAX_VALUE;
        }
        if(dp[amt][in]!=-1){
            return dp[amt][in];
        }
        int ans=Integer.MAX_VALUE;
        for(int i=in;i<coin.length;i++){
            
                int an=coin(coin,amt-coin[i],i,dp);
                if(an!=Integer.MAX_VALUE){
                    ans=Math.min(an+1,ans);
                }
            
        }
        return dp[amt][in]=ans;
    }
}