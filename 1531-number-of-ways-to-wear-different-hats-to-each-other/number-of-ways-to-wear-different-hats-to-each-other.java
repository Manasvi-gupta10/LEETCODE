class Solution {
    public int numberWays(List<List<Integer>> hats) {
        int n=hats.size();
        int[][] ar=new int[n+1][41];
        for(int i=0;i<n;i++){
            for(int j=0;j<hats.get(i).size();j++){
                int hat=hats.get(i).get(j);
                ar[i][hat]=1;
            }
        }
        int[][] dp=new int[1025][41];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return ways(ar,n,0,0,dp);
    }
    public int ways(int[][] ar,int n,int mask,int i,int[][] dp){
        if(mask==(1<<n)-1){
            return 1;
        }
        if(i>40){
            return 0;
        }
        if(dp[mask][i]!=-1){
            return dp[mask][i];
        }
        int ans=0;
        ans=ways(ar,n,mask,i+1,dp);
        for(int j=0;j<n;j++){
            if((ar[j][i]==1)&&(mask&(1<<j))==0){
                ans=(ans+ways(ar,n,(mask|(1<<j)),i+1,dp))%1000000007;
            }
        }
        return dp[mask][i]=ans;
    }
}