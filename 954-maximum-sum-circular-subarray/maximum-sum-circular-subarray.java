class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n=nums.length;
        int linears=maxsum(nums);
        int totsum=0;
        for(int i=0;i<n;i++){
            totsum+=nums[i];
        }
        for(int i=0;i<n;i++){
            nums[i]=nums[i]*-1;
        }
        int minsum=maxsum(nums);
        if(linears<0){
            return linears;
        }
        return Math.max(linears,totsum+minsum);
    }
    public int maxsum(int[] ar){
        int s=0;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<ar.length;i++){
            s+=ar[i];
            ans=Math.max(ans,s);
            if(s<0){
                s=0;
            }
        }
        return ans;
    }
}