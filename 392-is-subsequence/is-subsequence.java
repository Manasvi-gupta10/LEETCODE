class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0){
            return true;
        }
        return sub(s,t,0,0);
    }
    public boolean sub(String s,String t,int i,int j){
        if(i==s.length()&&j==t.length()){
            return true;
        }
        if(i==s.length()){
            return true;
        }
        if(i==s.length()||j==t.length()){
            return false;
        }

        boolean ans=false;
        if(s.charAt(i)==t.charAt(j)){
            ans=sub(s,t,i+1,j+1);
        }else{
            ans=sub(s,t,i,j+1);
        }
        return ans;
    }
}