class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=nums[0];
        int len=1;
        for(int i=1;i<n;i++){
            if(nums[i]>dp[len-1]){
                dp[len]=nums[i];
                len++;
            }else{
                int in=find(dp,0,len-1,nums[i]);
                dp[in]=nums[i];
            }
        }
        return len;
    }
    public int find(int[] ar,int i,int j,int v){
        int ans=0;
        while(i<=j){
            int m=i+(j-i)/2;
            if(ar[m]>=v){
                ans=m;
                j=m-1;
            }else{
                i=m+1;
            }
        }
        return ans;
    }
}