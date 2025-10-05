class Solution {
    public void reverseString(char[] s) {
        rev(s,0,s.length-1);
    }
    public void rev(char[] s,int si,int ei){
        if(si>ei){
            return;
        }
        char c=s[si];
        s[si]=s[ei];
        s[ei]=c;
        rev(s,si+1,ei-1);
    }
}