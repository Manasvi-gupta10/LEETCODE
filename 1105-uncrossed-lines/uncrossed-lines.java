class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        return maxlines(nums1,nums2);
        
    }
    public static int maxlines(int[] s,int[] g){
        int[][] dp=new int[s.length+1][g.length+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int ans=0;
        if(s[i-1]==g[j-1]){
            ans=1+dp[i-1][j-1];
        }else{
            int f=dp[i-1][j];
            int se=dp[i][j-1];
            ans=Math.max(f,se);
        }
        dp[i][j]=ans;
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}