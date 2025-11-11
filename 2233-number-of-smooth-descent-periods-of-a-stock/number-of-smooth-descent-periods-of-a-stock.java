class Solution {
    public long getDescentPeriods(int[] prices) {
        int n=prices.length;
        int[] ar=new int[n];
        long ans=0;
        ar[0]=1;
        for(int i=1;i<n;i++){
            if(prices[i]+1==prices[i-1]){
                ar[i]=ar[i-1]+1;
            }else{
                ar[i]=1;
            }
        }
        
        for(int i=0;i<n;i++){
            ans+=ar[i];
        }
        
        return ans;
    }
}