class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        int n=prizePositions.length;
        int[] left=new int[n];//0 se i m ek k length ka segment nikalo jisme prizez cover maximum hone chaiye
        int[] right=new int[n];
        left[0]=1;
        for(int i=1,j=0;i<n;i++){
            if(prizePositions[i]-prizePositions[j]>k){
                j++;
            }
            left[i]=Math.max(left[i-1],i-j+1);
        }
        right[n-1]=1;
        for(int i=n-2,j=n-1;i>=0;i--){
            if(prizePositions[j]-prizePositions[i]>k){
                j--;
            }
            right[i]=Math.max(right[i+1],j-i+1);
        }
        int ans=0;
        for(int i=0;i<=n;i++){
            int lp=(i==0)?0:left[i-1];
            int rp=(i==n)?0:right[i];
            ans=Math.max(ans,lp+rp);
        }
        return ans;
    }
}