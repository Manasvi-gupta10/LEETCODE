class Solution {
    public long maxPoints(int[] technique1, int[] technique2, int k) {
        int n=technique1.length;
        long ans=0;
        for(int i=0;i<n;i++){
            ans+=technique1[i];

        }
        int[][] ar=new int[n][2];
        for(int i=0;i<n;i++){
            ar[i][0]=technique2[i]-technique1[i];
            ar[i][1]=i;
        }
        Arrays.sort(ar,(a,b)->b[0]-a[0]);
        int a=n-k;
        int i=0;
        while(a-->0&&i<n){
            if(ar[i][0]<0){
                break;
            }
            ans-=technique1[ar[i][1]];
            ans+=technique2[ar[i][1]];
            i++;

        }
        return ans;

        
    }
}