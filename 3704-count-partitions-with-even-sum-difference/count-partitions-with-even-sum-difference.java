class Solution {
    public int countPartitions(int[] nums) {
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n-1;i++){
            int l=0,r=0;
            for(int j=0;j<=i;j++){
                l+=nums[j];
            }
            for(int j=i+1;j<n;j++){
                r+=nums[j];
            }
            int dif=l-r;
            if(dif%2==0){
                ans=ans+1;
            }
        }
        return ans;
    }
}