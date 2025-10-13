class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        int closet=nums[0]+nums[1]+nums[2];
        for(int i=0;i<=n-3;i++){
            int l=i+1;
            int r=n-1;
            while(l<r){
                int s=nums[i]+nums[l]+nums[r];
                if(Math.abs(target-s)<Math.abs(target-closet)){
                    closet=s;
                }
                if(s<target){
                    l++;
                }else if(s>target){
                    r--;
                }else{
                    return s;
                }
            }
        }
        return closet;
    }
}