class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }else{
                return a[1]-b[1];
            }
        });
        int ans=0;
        int end=intervals[0][1];
        for(int i=1;i<n;i++){
            if(intervals[i][0]<end){
                ans++;
                end=Math.min(end,intervals[i][1]);
            }else{
                end=intervals[i][1];
            }
        }
        return ans;
    }
}