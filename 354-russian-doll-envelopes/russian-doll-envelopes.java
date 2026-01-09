class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n=envelopes.length;
        Arrays.sort(envelopes,(a,b)->{
            if(a[0]==b[0]){
                return b[1]-a[1];
            }else{
                return a[0]-b[0];
            }
        });
        int[] dp=new int[n];
        int len=1;
        dp[0]=envelopes[0][1];
        for(int i=1;i<n;i++){
            if(dp[len-1]<envelopes[i][1]){
                dp[len]=envelopes[i][1];
                len++;
            }else{
                int idx=find(dp,len,envelopes[i][1]);
                dp[idx]=envelopes[i][1];
            }
        }
        return len;
    }
    public int find(int[] dp,int len,int e1){
        int lo=0,hi=len-1;
        int ans=-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(dp[mid]>=e1){
                ans=mid;
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return ans;
    }
}