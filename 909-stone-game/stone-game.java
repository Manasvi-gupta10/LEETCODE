class Solution {
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        int[][] dp=new int[n][n];

        int maxa=maxadv(piles,0,n-1,dp);
        return maxa>0;
    }
    public int maxadv(int[] p,int i,int j,int[][] dp){
        if(i==j){
            return p[i];
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int l=p[i]-maxadv(p,i+1,j,dp);
        int r=p[j]-maxadv(p,i,j-1,dp);

        return dp[i][j]=Math.max(l,r);
    }
}