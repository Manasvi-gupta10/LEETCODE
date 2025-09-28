class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()][word2.length()];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return mindelete(word1,word2,0,0,dp);
    }
    public int mindelete(String w1,String w2,int i,int j,int[][] dp){
        if(i==w1.length()){
            return w2.length()-j;
        }
        if(j==w2.length()){
            return w1.length()-i;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        if(w1.charAt(i)==w2.charAt(j)){
            ans=mindelete(w1,w2,i+1,j+1,dp);
        }
        else{
            int d1=mindelete(w1,w2,i+1,j,dp);
        int d2=mindelete(w1,w2,i,j+1,dp);
        ans=Math.min(d1,d2)+1;
        }
        return dp[i][j]=ans;
    }
}