class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int tot=0;
        for(int i=0;i<n;i++){
            tot+=nums[i];
        }
        if(tot%2!=0){
            return false;
        }
        int target=tot/2;
        return poss(target,nums);
    }
    public boolean poss(int target,int[] ar){
        int n=ar.length;
        boolean[][] dp=new boolean[n+1][target+1];
        Arrays.fill(dp[0],false);
        for(int i=0;i<dp.length;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                boolean p=false;
                if(j>=ar[i-1]){
                    p=dp[i-1][j-ar[i-1]];
                }
                boolean np=dp[i-1][j];
                dp[i][j]=p||np;
            }
        }
        return dp[dp.length-1][dp[0].length-1];

    }
}