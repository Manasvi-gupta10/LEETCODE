class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int ans=0;
        int s=0,e=0,flip=0;
        while(e<n){
            if(nums[e]==0){
                flip++;
            }
            while(flip>k&&s<=e){
                if(nums[s]==0){
                    flip--;
                }
                s++;
            }
            ans=Math.max(ans,e-s+1);
            e++;
        }
        return ans;
    }
}