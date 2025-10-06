class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp=new int[cost.length];
        Arrays.fill(dp,-1);
        int one=mincost(dp,cost,0);
        int sec=mincost(dp,cost,1);
        return Math.min(one,sec);
    }
    public int mincost(int[] dp,int[] cost,int in){
        if(in>=cost.length){
            return 0;
        }
        if(dp[in]!=-1){
            return dp[in];
        }
        return dp[in]=cost[in]+Math.min(mincost(dp,cost,in+1),mincost(dp,cost,in+2));
    }
}