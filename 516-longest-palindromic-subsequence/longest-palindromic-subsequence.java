class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int[][] dp=new int[n+1][n+1];
        StringBuilder sb=new StringBuilder(s);
        String s2=sb.reverse().toString();
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(s.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    int f=dp[i-1][j];
                    int se=dp[i][j-1];
                    dp[i][j]=Math.max(f,se);
                }
            }
        }
        return dp[n][n];
    }
     
}