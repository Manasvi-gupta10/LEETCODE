class Solution {
    public int minimumOperations(int[] nums) {
        int ans=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]%3==0){
                continue;
            }
            
            ans++;
        }
        return ans;
    }
}