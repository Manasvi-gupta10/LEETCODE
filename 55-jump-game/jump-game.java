class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        if(n==1){
            return true;
        }
        int i=0;
        int maxjump=0;
        for(;i<n;i++){
            if(i>maxjump){
                return false;
            }
            maxjump=Math.max(maxjump,i+nums[i]);
            if(i>=n-1){
                return true;
            }
        }
        return i>=n-1;

    }
}