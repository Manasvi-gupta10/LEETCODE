class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int[][][] dp=new int[grid.length][grid[0].length][k];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return path(grid,0,0,k,0,dp)%1000000007;

        
    }
    public int path(int[][] ar,int r,int c,int k,int rem,int[][][] dp){
        if(r==ar.length-1&&c==ar[0].length-1){
            rem=(rem+ar[r][c])%k;
            if(rem==0){
                return 1;
            }else{
                return 0;
            }
        }
        if(r>=ar.length||c>=ar[0].length){
            return 0;
        }
        if(dp[r][c][rem]!=-1){
            return dp[r][c][rem];
        }
        int nr=(rem+ar[r][c])%k;

        int down=path(ar,r+1,c,k,nr,dp)%1000000007;
        int right=path(ar,r,c+1,k,nr,dp)%1000000007;
        return dp[r][c][rem]=(down+right)%1000000007;
    }
}