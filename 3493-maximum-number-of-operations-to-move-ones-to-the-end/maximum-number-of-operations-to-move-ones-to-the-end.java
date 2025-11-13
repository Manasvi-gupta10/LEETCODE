class Solution {
    public int maxOperations(String s) {
        int n=s.length();
        int i=0;
        int ans=0;
        int on=0;
        while(i<n){
            if(s.charAt(i)=='1'){
                on++;
            }
            if(i-1>=0&&s.charAt(i-1)=='1'&&s.charAt(i)=='0'){
                ans+=on;
            }
            i++;
        }
        return ans;
    }
}