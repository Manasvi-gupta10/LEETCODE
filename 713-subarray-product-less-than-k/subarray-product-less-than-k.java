class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n=nums.length;
        int ei=0,si=0;
        int ans=0;
        int p=1;
        while(ei<n){
            p*=nums[ei];
            while(si<=ei&&p>=k){
                p=p/nums[si];
                si++;
            }
            ans+=(ei-si+1);
            ei++;
        }
        return ans;
        
    }
}