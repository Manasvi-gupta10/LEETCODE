class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i]>=k){
                return 1;
            }
        }
        for(int i=0;i<n;i++){
            int orop=nums[i];
            for(int j=i+1;j<n;j++){
                orop=orop|nums[j];
                if(orop>=k){
                    ans=Math.min(ans,j-i+1);
                }
            }
        }
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;

        
    }
}