class Solution {
    public String longestNiceSubstring(String s) {
        int n=s.length();
        String ans="";
        for(int len=1;len<=n;len++){
            for(int i=len;i<=n;i++){
                int j=i-len;
                String sub=s.substring(j,i);
                if(nice(sub)){
                    if(sub.length()>ans.length()){
                        ans=sub;
                    }
                }

            }
        }
        return ans;
        
    }
    public boolean nice(String s){
        int[] small=new int[26];
        int[] big=new int[26];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>=65&&s.charAt(i)<=90){
                big[s.charAt(i)-'A']=1;
            }else{
                small[s.charAt(i)-'a']=1;
            }
        }
        for(int i=0;i<26;i++){
            if(big[i]!=small[i]){
                return false;
            }
        }
        return true;
    }
}