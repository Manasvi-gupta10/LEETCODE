class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp=new int[s1.length()][s2.length()];
        return minascii(s1,s2,0,0,dp);
    }
    public int minascii(String s1,String s2,int i,int j,int[][] dp){
        if(i==s1.length()){
            int as=0;
            for(int k=j;k<s2.length();k++){
                as+=(int)s2.charAt(k);
            }
            return as;
        }
        if(j==s2.length()){
            int as=0;
            for(int k=i;k<s1.length();k++){
                as+=(int)s1.charAt(k);
            }
            return as;
        }   
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int ans=0;
        if(s1.charAt(i)==s2.charAt(j)){
            ans=minascii(s1,s2,i+1,j+1,dp);
        }else{
            int d1=(int)s1.charAt(i)+minascii(s1,s2,i+1,j,dp);
            int d2=(int)s2.charAt(j)+minascii(s1,s2,i,j+1,dp);
            ans=Math.min(d1,d2);
        }
        return dp[i][j]=ans;
    }
}