class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()][word2.length()];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }

        return minsteps(word1,word2,0,0,dp);
        
    }
    public int minsteps(String s1,String s2,int i,int j,int[][] dp){
        if(i==s1.length()){
            return s2.length()-j;
        }
        if(j==s2.length()){
            return s1.length()-i;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=minsteps(s1,s2,i+1,j+1,dp);
        }else{
            int f=minsteps(s1,s2,i+1,j,dp)+1;
            int se=minsteps(s1,s2,i,j+1,dp)+1;
            return dp[i][j]=Math.min(f,se);
        }
    }
}