class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;

        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-77777);

        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans=Math.min(mincost(matrix,0,i,dp),ans);
        }
        return ans;
    }
    public int mincost(int[][] ar,int i,int j,int[][] dp){
        if(j>=ar.length||j<0){
            return Integer.MAX_VALUE;
        }
        if(i==ar.length-1){
            return ar[i][j];
        }
        if(dp[i][j]!=-77777){
            return dp[i][j];
        }


        int ld=mincost(ar,i+1,j-1,dp);
        int rd=mincost(ar,i+1,j+1,dp);
        int d=mincost(ar,i+1,j,dp);
        return dp[i][j]=Math.min(d,Math.min(ld,rd))+ar[i][j];
    }
}