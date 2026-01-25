class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int mn=nums[k-1]-nums[0];
        for(int i=k;i<n;i++){
            mn=Math.min(mn,nums[i]-nums[i-k+1]);
        }
        return mn;
    }
}