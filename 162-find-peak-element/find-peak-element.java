class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        if(n==1){
            return 0;
        }
        if(n==2){
            if(nums[0]>nums[1]){
                return 0;
            }else{
                return 1;
            }
        }
        int lo=0,hi=n-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(mid==0&&nums[mid]>nums[mid+1]){
                return 0;

            }
            if(mid==n-1&&nums[n-1]>nums[n-2]){
                return n-1;
            }
            if(mid-1>=0&&mid+1<n&&nums[mid-1]<nums[mid]&&nums[mid]>nums[mid+1]){
                return mid;
            }else if(mid-1>=0&&nums[mid-1]>nums[mid]){
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return -1;
    }
}