class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int total=0;
        for(int i=0;i<n;i++){
            total+=nums[i];
        }
        if(total%2!=0){
            return false;
        }
        int target=total/2;
        boolean[][] dp=new boolean[target+1][n+1];
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=true;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                boolean inc=false,ex=false;
                if(i-nums[j-1]>=0){
                    inc=dp[i-nums[j-1]][j-1];
                }
                ex=dp[i][j-1];
                dp[i][j]=inc||ex;

            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}