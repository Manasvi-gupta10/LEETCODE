class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] ar=new int[n+2];
        int[][] dp=new int[ar.length][ar.length];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=1;i<=n;i++){
            ar[i]=nums[i-1];
        }
        ar[0]=ar[ar.length-1]=1;
        return maxcoins(ar,0,ar.length-1,dp);
    }
    public int maxcoins(int[] ar,int i,int j,int[][] dp){
        if(i+1==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=Integer.MIN_VALUE;
        for(int k=i+1;k<j;k++){
            int left=maxcoins(ar,i,k,dp);
            int right=maxcoins(ar,k,j,dp);
            int cur=ar[i]*ar[k]*ar[j];
            ans=Math.max(ans,cur+left+right);
        }
        return dp[i][j]=ans;
    }
}