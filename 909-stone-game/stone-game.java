class Solution {
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        int tot=0;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            tot+=piles[i];
        }
        int maxp1=maxsc(piles,0,n-1,dp);
        int maxp2=tot-maxp1;
        if(maxp1>maxp2){
            return true;
        }
        return false;
    }
    public int maxsc(int[] ar,int i,int j,int[][] dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int f=ar[i]+Math.min(maxsc(ar,i+1,j-1,dp),maxsc(ar,i+2,j,dp));
        int s=ar[j]+Math.min(maxsc(ar,i,j-2,dp),maxsc(ar,i+1,j-1,dp));
        return dp[i][j]=Math.max(f,s);
    }
}