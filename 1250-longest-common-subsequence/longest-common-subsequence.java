class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int i=text1.length();
        int j=text2.length();
        int[][] dp=new int[i][j];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return lcs(text1,text2,0,0,dp);
    }
    public int lcs(String s,String g,int i,int j,int[][] dp){
        if(i==s.length()||j==g.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        if(s.charAt(i)==g.charAt(j)){
            ans=1+lcs(s,g,i+1,j+1,dp);
        }else{
            int f=lcs(s,g,i+1,j,dp);
            int se=lcs(s,g,i,j+1,dp);
            ans=Math.max(f,se);
        }
        return dp[i][j]=ans;
    }
}