class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp=new Boolean[s.length()];
        return wbreak(s,wordDict,0,dp);
    }
    public boolean wbreak(String s,List<String> word,int i,Boolean[] dp){
        if(i==s.length()){
            return true;
        }
        if(dp[i]!=null){
            return dp[i];
        }

        for(int in=i+1;in<=s.length();in++){
            String sub=s.substring(i,in);
            if(word.contains(sub)){
                if(wbreak(s,word,in,dp)){
                    return dp[i]=true;
                }
            }

        }
        return dp[i]=false;
    }
}