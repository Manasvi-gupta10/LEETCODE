class Solution {
    public int countTexts(String pressedKeys) {
        int n=pressedKeys.length();
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return count(pressedKeys,0,dp);
    }
    public int count(String keys,int i,int[] dp){
        if(i==keys.length()){
            return 1;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int ans=0;
        int maxl=3;
        if(keys.charAt(i)=='7'||keys.charAt(i)=='9'){
            maxl=4;

        }
        for(int l=1;l<=maxl;l++){
            if(i+l<=keys.length()){
               
            if(same(keys,i,i+l)){
                ans=(ans+count(keys,i+l,dp))%1000000007;
            }
            }
        }
        return dp[i]=ans%1000000007;
    }
    public boolean same(String s,int in,int j){
        char ch=s.charAt(in);
        for(int i=in+1;i<j;i++){
            if(s.charAt(i)!=ch){
                return false;
            }
        }
        return true;
    }
}