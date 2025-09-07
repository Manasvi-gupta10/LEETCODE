class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=1;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int in=0,ex=0;
                if(t.charAt(i-1)==s.charAt(j-1)){
                    in=dp[i-1][j-1];
                }
                ex=dp[i][j-1];
                dp[i][j]=in+ex;
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}