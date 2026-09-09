class Solution {
    class pair{
        int r;
        int c;
        int cost;
        public pair(int r,int c,int cost){
            this.r=r;
            this.c=c;
            this.cost=cost;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int r=mat.length;
        int c=mat[0].length;
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        boolean[][] visit=new boolean[r][c];
         int[][] ans=new int[r][c];
         for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i][j]==0){
                    pq.add(new pair(i,j,0));
                }
            }
         }
         int[] row={1,-1,0,0};
         int[] col={0,0,1,-1};
         while(!pq.isEmpty()){
            pair p=pq.poll();
            int i=p.r;
            int j=p.c;
            if(visit[i][j]){
                continue;
            }
            visit[i][j]=true;
            if(mat[i][j]==1){
                ans[i][j]=p.cost;
            }
            for(int k=0;k<4;k++){
                int ni=i+row[k];
                int nj=j+col[k];
                if(ni<0||nj<0||ni>=r||nj>=c||visit[ni][nj]){
                    continue;
                }
                pq.add(new pair(ni,nj,p.cost+1));
            }
         }
         return ans;
    }
}