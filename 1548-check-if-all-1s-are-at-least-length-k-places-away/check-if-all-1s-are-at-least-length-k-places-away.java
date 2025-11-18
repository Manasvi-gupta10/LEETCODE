class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n=nums.length;
        int st=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                st=i;
                break;
            }
        }
        for(int i=st+1;i<n;i++){
            if(nums[i]==1&&i-st-1<k){
                return false;
            }else if(nums[i]==1){
                st=i;
            }
        }
        return true;
    }
}