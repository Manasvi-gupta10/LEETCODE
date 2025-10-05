class Solution {
    public int minPairSum(int[] nums) {
        int ans=0;
        Arrays.sort(nums);
        int n=nums.length;
        int i=0,j=n-1;
        while(i<=j){
            ans=Math.max(ans,nums[i]+nums[j]);
            i++;
            j--;
        }
        return ans;
    }
}