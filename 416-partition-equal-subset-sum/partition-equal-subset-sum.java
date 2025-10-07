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
        Boolean[][] dp=new Boolean[n][target+1];
        return make(nums,0,target,dp);
    }
    public boolean make(int[] ar,int in,int val,Boolean[][] dp){
        if(val==0){
            return true;
        }
        if(val<0){
            return false;
        }
        if(in==ar.length){
            return false;
        }
        if(dp[in][val]!=null){
            return dp[in][val];
        }
        boolean inc=make(ar,in+1,val-ar[in],dp);
        boolean ex=make(ar,in+1,val,dp);
        return dp[in][val]=inc||ex;
    }
}