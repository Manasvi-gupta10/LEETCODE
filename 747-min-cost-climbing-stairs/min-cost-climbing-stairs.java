class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        int z=steps(cost,0,dp);
        //Arrays.fill(dp,-1);
        int o=steps(cost,1,dp);
        return Math.min(z,o);
    }
    public int steps(int[] ar,int i,int[] dp){
        if(i>=ar.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int one=steps(ar,i+1,dp);
        int two=steps(ar,i+2,dp);
        return dp[i]=Math.min(one,two)+ar[i];

    }
}