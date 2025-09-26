class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            while(nums[i]>0&&nums[i]<n&&nums[i]!=nums[nums[i]-1]&&nums[i]>0){
                swap(nums,i,nums[i]-1);
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return n+1;
    }
    public void swap(int[] ar,int i,int j){
        int t=ar[i];
        ar[i]=ar[j];
        ar[j]=t;
    }
}