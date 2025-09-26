class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int mn=Integer.MAX_VALUE;
        int ans=0;
        for(int i=0;i<n;i++){
            mn=Math.min(mn,prices[i]);
            if(mn!=prices[i]){
                ans=Math.max(ans,prices[i]-mn);
            }
        }
        return ans;
    }
}