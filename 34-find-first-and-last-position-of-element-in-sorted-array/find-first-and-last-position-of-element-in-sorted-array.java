class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int[] ans=new int[2];
        Arrays.fill(ans,-1);
        int i=0;
        while(i<n){
            if(nums[i]==target){
                ans[0]=i;
                while(i<n&&nums[i]==target){
                    i++;
                }
                ans[1]=i-1;
                break;
            }
            i++;
        }
        return ans;
    }
}