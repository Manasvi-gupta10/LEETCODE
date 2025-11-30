class Solution {
    public int maxRotateFunction(int[] nums) {
        int n=nums.length;
        long fp=0;
        long sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            fp+=i*nums[i];
        }
        long ans=fp;
        for(int i=1;i<n;i++){
            long cur=fp+sum-(long)n*nums[n-i];
            fp=cur;
            ans=Math.max(ans,cur);
        }
        return (int)ans;
        
    }
}