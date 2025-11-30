class Solution {
    public int maxBalancedShipments(int[] weight) {
        int n=weight.length;
        int ans=0;
        int mx=weight[0];
        for(int i=1;i<n;i++){
            if(mx>weight[i]){
                ans++;
                mx=Integer.MIN_VALUE;

            }
            else{
                
                mx=weight[i];
            }
        }
        
        return ans;
    }
}