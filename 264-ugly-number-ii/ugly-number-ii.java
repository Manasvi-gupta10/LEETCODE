class Solution {
    public int nthUglyNumber(int n) {
        int[] dp=new int[n];
        dp[0]=1;
        int p2=0;
        int p3=0;
        int p5=0;
        for(int i=1;i<n;i++){
            int next2=dp[p2]*2;
            int next3=dp[p3]*3;
            int next5=dp[p5]*5;
            int next=Math.min(next2,Math.min(next3,next5));
            dp[i]=next;
            if(next==next2){
                p2++;
            }
            if(next==next3){
                p3++;
            }
            if(next==next5){
                p5++;
            }

        }
        return dp[n-1];
    }
}