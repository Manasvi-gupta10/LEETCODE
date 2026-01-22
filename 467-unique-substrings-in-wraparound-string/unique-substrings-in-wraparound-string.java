class Solution {
    public int findSubstringInWraproundString(String s) {
        int n=s.length();
        int[] maxlen=new int[26];
        int len=1;
        maxlen[s.charAt(0)-'a']=len;
        int ans=0;
        for(int i=1;i<n;i++){
            int ch1=s.charAt(i-1);
            int ch2=s.charAt(i);
            if(ch2==('a'+(ch1-'a'+1)%26)){
                len++;
            }else{
                len=1;
            }
            maxlen[ch2-'a']=Math.max(len,maxlen[ch2-'a']);
        }
        for(int v:maxlen){
            ans+=v;
        }
        return ans;
    }
}