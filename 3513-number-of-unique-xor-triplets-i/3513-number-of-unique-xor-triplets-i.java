class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        if(n<=2){
            return n;
        }
        int ans=0;
        while(n>0){
            ans++;
            n=n>>1;
        }
        return 1<<ans;
    }
}