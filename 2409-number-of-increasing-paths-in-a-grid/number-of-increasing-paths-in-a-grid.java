class Solution {
    public int countPaths(int[][] grid) {
        int e=Integer.MIN_VALUE;
        long ans=0;
        int n=grid.length;
        int m=grid[0].length;
        long[][] dp=new long[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans+=path(grid,i,j,e,dp);
            }
        }
        return (int)(ans%1000000007);
    }
    public long path(int[][] ar,int r,int c,int e,long[][] dp){
        if(r<0||c<0||r>=ar.length||c>=ar[0].length||ar[r][c]<=e){
            return 0;
        }
        if(dp[r][c]!=0){
            return dp[r][c];
        }
        int[] row={0,0,1,-1};
        int[] col={1,-1,0,0};
        int tot=1;
        for(int i=0;i<4;i++){
            tot+=path(ar,r+row[i],c+col[i],ar[r][c],dp)%1000000007;

        }
        return dp[r][c]=tot;

    }
}