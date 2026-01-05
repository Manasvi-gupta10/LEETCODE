class Solution {
    public String reversePrefix(String s, int k) {
        String ans="";
        for(int i=k-1;i>=0;i--){
            ans+=s.charAt(i);
        }
        if(k==s.length()){
            return ans;
        }
        ans+=s.substring(k);
        return ans;
    }
}