class Solution {
    public int partitionArray(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int ans=1;
        int min=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]-min>k){
                ans++;
                min=nums[i];
            }
        }
        return ans;
    }
}