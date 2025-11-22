class Solution {
    public int minimumOperations(int[] nums) {
        int ans=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]%3==0){
                continue;
            }
            int r1=nums[i]%3;
            int r2=3-nums[i]%3;
            
            ans+=Math.min(r1,r2);
        }
        return ans;
    }
}