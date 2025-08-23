class Solution {
    public int minIncrementForUnique(int[] nums) {
        int n=nums.length;
        int ans=0;
        Arrays.sort(nums);
        for(int i=0;i<n-1;i++){
            int dif=nums[i+1]-nums[i];
            if(dif<=0){
                int d=Math.abs(dif)+1;
                nums[i+1]=nums[i+1]+d;
                ans+=d;
            }
        }
        return ans;
    }
}