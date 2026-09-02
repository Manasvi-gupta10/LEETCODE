class Solution {
    class pair{
        int ind;
        double dis;
        public pair(int ind,double dis){
            this.ind=ind;
            this.dis=dis;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        int n=points.length;
        int[][] ans=new int[k][2];
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->Double.compare(a.dis,b.dis));
        for(int i=0;i<n;i++){
            double dis=Math.sqrt((points[i][0]*points[i][0])+(points[i][1]*points[i][1]));
            pq.add(new pair(i,dis));
        }
        for(int i=0;i<k;i++){
            pair r=pq.poll();
            ans[i][0]=points[r.ind][0];
            ans[i][1]=points[r.ind][1];
        }
        return ans;

    }
}