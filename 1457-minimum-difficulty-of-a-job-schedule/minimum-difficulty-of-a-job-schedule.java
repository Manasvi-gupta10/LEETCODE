class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n=jobDifficulty.length;
        int[][] dp=new int[n][d+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=cut(jobDifficulty,d,0,dp);
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
    public int cut(int[] ar,int d,int i,int[][] dp){
        if(d==1){
            int mx=0;
            for(int k=i;k<ar.length;k++){
                mx=Math.max(mx,ar[k]);
            }
            return mx;
        }
        if(dp[i][d]!=-1){
            return dp[i][d];
        }
        int maxtoday=0;
        int ans=Integer.MAX_VALUE;
        for(int in=i;in<=ar.length-d;in++){
            maxtoday=Math.max(maxtoday,ar[in]);
            ans=Math.min(ans,maxtoday+cut(ar,d-1,in+1,dp));
        }
        return dp[i][d]=ans;
    }
}