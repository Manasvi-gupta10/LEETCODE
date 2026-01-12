class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n=dist.length;
        int[] time=new int[n];
        for(int i=0;i<n;i++){
            time[i]=(int)Math.ceil((double)dist[i]/speed[i]);

        }
        Arrays.sort(time);
        int ans=0;
        int t=1;
        for(int i=0;i<n;i++){
            if(t<=time[i]){
                ans++;
                t++;
            }else{
                break;
            }
        }
        return ans;
    }
}