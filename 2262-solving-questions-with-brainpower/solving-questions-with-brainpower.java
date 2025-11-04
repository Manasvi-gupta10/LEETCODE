class Solution {
    public long mostPoints(int[][] questions) {
        int n=questions.length;
        long[] dp=new long[n];
        return maxpoints(questions,0,dp);
    }
    public long maxpoints(int[][] ar,int i,long[] dp){
        if(i>=ar.length){
            return 0;
        }
        if(dp[i]!=0){
            return dp[i];
        }
        long in=ar[i][0]+maxpoints(ar,i+ar[i][1]+1,dp);
        long ex=maxpoints(ar,i+1,dp);
        return dp[i]=Math.max(in,ex);
    }
}