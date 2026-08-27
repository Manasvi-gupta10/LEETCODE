class Solution {
    class pair{
        int r;
        int c;
        int min;
        public pair(int r,int c,int min){
            this.r=r;
            this.c=c;
            this.min=min;
        }
    }
    public int orangesRotting(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        int fresh=0;
        Queue<pair> q=new LinkedList<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==2){
                    q.add(new pair(i,j,0));
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int[] row={0,0,1,-1};
        int[] col={1,-1,0,0};
        int ans=0;
        int cn=0;
        while(!q.isEmpty()){
            pair rp=q.poll();
            ans=Math.max(ans,rp.min);
            for(int i=0;i<4;i++){
                int nr=rp.r+row[i];
                int nc=rp.c+col[i];
                if(nr<0||nc<0||nr>=r||nc>=c||grid[nr][nc]!=1){
                    continue;
                }
                grid[nr][nc]=2;
                cn++;
                q.add(new pair(nr,nc,rp.min+1));
            }
        }
        if(cn!=fresh){
            return -1;
        }
        return ans;
    }
}