class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int[] ans=new int[2];
        Arrays.fill(ans,-1);
        int lo=0,hi=n-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(nums[mid]==target){
                ans[0]=mid;
                hi=mid-1;
            }else if(nums[mid]<target){
                lo=mid+1;
            }else{
                hi=mid-1;
            }
        }
        lo=0;
        hi=n-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(nums[mid]==target){
                ans[1]=mid;
                lo=mid+1;
            }else if(target<nums[mid]){
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return ans;
    }
}