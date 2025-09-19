class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        int n=points.length;
        int ans=0;
        int i=0;
        Arrays.sort(points,(a,b)->Integer.compare(a[0], b[0]));
        while(i<n){
            ans++;
            int sw=points[i][0];
            int ew=sw+w;
            i++;
            while(i<n&&points[i][0]<=ew){
                i++;
            }
        }
        return ans;
    }
}