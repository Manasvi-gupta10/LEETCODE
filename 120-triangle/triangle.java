class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n][triangle.get(n-1).size()];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],100000);
        }
        return path(triangle,0,0,dp);
    }
    public int path(List<List<Integer>> triangle,int i,int j,int[][] dp){

        if(i>=triangle.size()){
            return 0;
        }
        if(dp[i][j]!=100000){
            return dp[i][j];
        }
         int s=path(triangle,i+1,j,dp)+triangle.get(i).get(j);
         int ad=path(triangle,i+1,j+1,dp)+triangle.get(i).get(j);
        return dp[i][j]=Math.min(s,ad);
    }
}