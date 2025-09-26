class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int lo=0,hi=n-1,mid=0;
        while(mid<=hi){
            if(nums[mid]==0){
                swap(mid,lo,nums);
                mid++;
                lo++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            //if(nums[mid]==2){
            else{
                swap(mid,hi,nums);
                hi--;
            }
        }
    }
    public void swap(int i,int j,int[] ar){
        int t=ar[i];
        ar[i]=ar[j];
        ar[j]=t;
    }
}