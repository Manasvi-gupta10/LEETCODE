class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n=nums.length;
        if(k==1){
            return nums;
        }
        int[] ans=new int[n-k+1];
        int c=1;
        for(int i=1;i<n;i++){
            if(nums[i]-1==nums[i-1]){
                c++;
            }
            else{
                c=1;
            }
            if(i-k+1<0){
                continue;
            }
            if(c>=k){
                ans[i-k+1]=nums[i];
            }else{
                ans[i-k+1]=-1;
            }

        }
        return ans;
    }
}