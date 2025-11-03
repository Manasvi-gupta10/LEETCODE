class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return way(n,0,dp);
    }
    public int way(int n,int cur,int[] dp){
        if(cur==n){
            return 1;
        }
        if(cur>n){
            return 0;
        }
        if(dp[cur]!=-1){
            return dp[cur];
        }

        int ans=0;
        ans+=way(n,cur+1,dp);
        ans+=way(n,cur+2,dp);
        return dp[cur]=ans;
    }
}