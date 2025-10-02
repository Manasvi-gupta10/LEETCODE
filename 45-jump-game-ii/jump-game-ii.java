class Solution {
    public int jump(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return minjump(nums,0,dp);
    }
    public int minjump(int[] nums,int i,int[] dp){
        if(i>=nums.length-1){
            return 0; 
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int an=Integer.MAX_VALUE;
        int maxj=nums[i];
        for(int j=1;j<=maxj;j++){
            if(i+j<nums.length){
                int moves=minjump(nums,i+j,dp);
                if (moves != Integer.MAX_VALUE) {
                    an = Math.min(an, moves + 1);
                }
               
            }
            
        }
        return dp[i]=an;
    }
}