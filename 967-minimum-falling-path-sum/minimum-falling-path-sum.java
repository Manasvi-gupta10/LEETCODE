class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int ans=Integer.MAX_VALUE;
        int[][] dp=new int[matrix.length][matrix[0].length];
        for(int[] a:dp){
            Arrays.fill(a,-66666);
        }
        for(int i=0;i<matrix[0].length;i++){
            ans=Math.min(ans,minsum(matrix,0,i,dp));
        }
        return ans;
    }
    public int minsum(int[][] mat,int cr,int cc,int[][] dp){
        if(cc>=mat[0].length||cc<0){
            
            return Integer.MAX_VALUE;
        }
        if(cr==mat.length-1){
            return mat[cr][cc];
        }
        if(dp[cr][cc]!=-66666){
            return dp[cr][cc];
        }
        int ld=minsum(mat,cr+1,cc-1,dp);
        int rd=minsum(mat,cr+1,cc+1,dp);
        int d=minsum(mat,cr+1,cc,dp);
        return dp[cr][cc]=Math.min(d,Math.min(ld,rd))+mat[cr][cc];
    }
}