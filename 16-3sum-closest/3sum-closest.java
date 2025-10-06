class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        int closet=nums[0]+nums[1]+nums[2];
        for(int i=0;i<=n-3;i++){
            int l=i+1;
            int r=n-1;
            
            while(l<r){
            int sum=nums[i]+nums[l]+nums[r];
            if(Math.abs(sum-target)<Math.abs(closet-target)){
                closet=sum;
            }
            if(sum<target){
                l++;
            }else if(sum>target){
                r--;
            }else{
                return sum;
            }
            }
        }
        return closet;
    }
}