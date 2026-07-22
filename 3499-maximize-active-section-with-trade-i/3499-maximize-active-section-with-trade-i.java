class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n=s.length();
        int ans=0;
        int mx=0;
        int pre=Integer.MIN_VALUE;
        int len=0;
        for(int i=0;i<n;){
            int j=i+1;
            while(j<n&&s.charAt(i)==s.charAt(j)){
                j++;
            }
            len=j-i;
            if(s.charAt(i)=='1'){
                ans+=len;
            }else{
                mx=Math.max(mx,pre+len);
                pre=len;
            }
            i=j;
        }
        return ans+mx;

    }
}