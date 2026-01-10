class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp=new int[s1.length()][s2.length()];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return min(s1,s2,0,0,dp);
    }
    public int min(String s1,String s2,int i,int j,int[][] dp){
        if(i==s1.length()){
            int s=0;
            for(int in=j;in<s2.length();in++){
                s+=(int)s2.charAt(in);
            }
            return s;
        }
        if(j==s2.length()){
            int s=0;
            for(int in=i;in<s1.length();in++){
                s+=(int)s1.charAt(in);
            }
            return s;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=min(s1,s2,i+1,j+1,dp);
        }else{
            int d1=min(s1,s2,i+1,j,dp)+(int)s1.charAt(i);
            int d2=min(s1,s2,i,j+1,dp)+(int)s2.charAt(j);
            return dp[i][j]=Math.min(d1,d2);
        }
    }
}