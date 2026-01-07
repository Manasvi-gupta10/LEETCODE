class Solution {
    public boolean validPartition(int[] nums) {
       Boolean[] dp=new Boolean[nums.length];
       

        return partition(nums,0,dp);
    }
    public boolean partition(int[] nums,int i,Boolean[] dp){
        if(i>=nums.length){
            return true;
        }
        if(dp[i]!=null){
            return dp[i];
        }
        int n=nums.length;
        boolean ans=false;
        if(i<n-1&&nums[i]==nums[i+1]){
            ans|=partition(nums,i+2,dp);
        }
        if(i<n-2&&nums[i]==nums[i+1]&&nums[i]==nums[i+2]){
            ans|=partition(nums,i+3,dp);
        }
        if(i<n-2&&nums[i]==nums[i+1]-1&&nums[i+1]==nums[i+2]-1){
            ans|=partition(nums,i+3,dp);
        }
        return dp[i]=ans;
    }
}