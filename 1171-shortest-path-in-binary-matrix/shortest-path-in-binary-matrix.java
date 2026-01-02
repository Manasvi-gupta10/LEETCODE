class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int[] row={1,0,-1,0,1,-1,1,-1};
        int[] col={0,1,0,-1,1,-1,-1,1};
        if(grid[0][0]==1){
            return -1;
        }
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(0,0,1));
        grid[0][0]=1;
        while(!q.isEmpty()){
            pair rp=q.poll();
            
            if(rp.r==n-1&&rp.c==n-1){
                return rp.dis;
            }
            for(int i=0;i<8;i++){
                int nr=rp.r+row[i];
                int nc=rp.c+col[i];
                if(nr>=0&&nr<n&&nc>=0&&nc<n&&grid[nr][nc]==0){
                    grid[nr][nc]=1;
                    q.add(new pair(nr,nc,rp.dis+1));
                }
            }
            
            
        }
        return -1;
    }
}
class pair{
    int r;
    int c;
    int dis;
    public pair(int r,int c,int dis){
        this.r=r;
        this.c=c;
        this.dis=dis;
    }
}