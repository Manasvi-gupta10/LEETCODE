class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        
        int ans=0;
        
        for(int i=0;i<n;i++){
            if(!isthere(s,i+1,n-1,s.charAt(i))){
                ans=Math.max(ans,flips(s,k,s.charAt(i)));
            }
        }
        return ans;
        
    }
    
    public int flips(String s,int k,char ch){
        int n=s.length();
        int si=0,ep=0,ans=0,flip=0;
        while(ep<n){
            if(s.charAt(ep)!=ch){
                flip++;
            }
            while(flip>k&&si<=ep){
                if(s.charAt(si)!=ch){
                    flip--;
                }
                si++;
            }
            ans=Math.max(ans,ep-si+1);
            ep++;
        }
        return ans;
    }
    public boolean isthere(String s,int si,int j,char ch){
        for(int i=si;i<=j;i++){
            if(s.charAt(i)==ch){
                return true;
            }
        }
        return false;
    }
}