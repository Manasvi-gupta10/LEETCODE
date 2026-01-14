class Solution {
    public long perfectPairs(int[] nums) {
        int n=nums.length;
        long ans=0;
        long[] ar=new long[n];
        for(int i=0;i<n;i++){
            ar[i]=Math.abs(nums[i]);
        }
        Arrays.sort(ar);
        int si=0,ei=0;
        while(ei<n){

            while(ar[ei]>2L*ar[si]&&si<=ei){
                si++;
            }
            ans+=(ei-si);
            ei++;
        }
        return ans;
        
    }
}