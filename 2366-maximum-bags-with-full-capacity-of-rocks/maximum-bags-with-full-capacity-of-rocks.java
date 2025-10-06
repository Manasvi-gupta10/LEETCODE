class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n=capacity.length;
        int ans=0;
        int[][] ar=new int[n][2];
        for(int i=0;i<n;i++){
            ar[i][0]=capacity[i];
            ar[i][1]=rocks[i];
        }
        Arrays.sort(ar,(a,b)->Integer.compare(a[0]-a[1],b[0]-b[1]));
        for(int i=0;i<n;i++){
            int need=ar[i][0]-ar[i][1];
            if(need<=additionalRocks){
                additionalRocks-=need;
                ans++;
            }
        }
        return ans;
    }
}