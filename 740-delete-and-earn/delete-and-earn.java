class Solution {
    public int deleteAndEarn(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int[] ar=new int[nums[n-1]+1];
        for(int i=0;i<n;i++){
            ar[nums[i]]+=nums[i];
        }
        int[] dp=new int[ar.length];
        return maxearn(ar,0,dp);

    }
    public int maxearn(int[] ar,int i,int[] dp){
        if(i>=ar.length){
            return 0;
        }
        if(dp[i]!=0){
            return dp[i];
        }
        int p=ar[i]+maxearn(ar,i+2,dp);
        int np=maxearn(ar,i+1,dp);
        return dp[i]=Math.max(p,np);

    }
}