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
                int in=index(dp,0,len-1,nums[i]);
                dp[in]=nums[i];
            }
        }
        return len;
    }
    public int index(int[] dp,int i,int j,int v){
        int an=0;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(dp[mid]>=v){
                an=mid;
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return an;
    }
}