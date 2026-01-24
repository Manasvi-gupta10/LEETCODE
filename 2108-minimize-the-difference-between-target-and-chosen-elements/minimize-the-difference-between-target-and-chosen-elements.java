class Solution {
    
    public int minimizeTheDifference(int[][] mat, int target) {
        int[][] dp=new int[mat.length][10000];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return mindiff(mat,target,0,0,dp);
    }
    public int mindiff(int[][] mat,int target,int r,int sum,int[][] dp){
        if(r>=mat.length){
            return Math.abs(target-sum);
        }
        if(dp[r][sum]!=-1){
            return dp[r][sum];
        }

        int mn=Integer.MAX_VALUE;
        for(int i=0;i<mat[0].length;i++){
            mn=Math.min(mn,mindiff(mat,target,r+1,sum+mat[r][i],dp));
        }
        return dp[r][sum]=mn;
    }
}