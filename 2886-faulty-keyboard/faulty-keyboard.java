
class Solution {
    public String finalString(String s) {
        String ans="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='i'){
                ans=new StringBuilder(ans).reverse().toString();;
                //convert to string builder than reverse method laga rhe aur usse fir se convert kr rhe in string
            }else{
                ans+=s.charAt(i);
            }
        }
        return ans;
    }
}