class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        int n=text.length();
        char c1=pattern.charAt(0);
        char c2=pattern.charAt(1);
        long posans=0;
        long cnt1=0;
        long cnt2=0;
        for(int i=0;i<n;i++){
            char ch=text.charAt(i);
            if(ch==c2){
                posans+=cnt1;//iise phle jitne bhi c1 ub sb ko pairup with abhi ka c2 isiliye utne add
                cnt2++;
            }
            if(ch==c1){
                cnt1++;
            }
        }
        //if c1 jyada toh ek bar c2 add krenge toh wo cnt1 times aur nye subsequence denge [same with c2]
        posans+=Math.max(cnt1,cnt2);
        return posans;
        
    }
}