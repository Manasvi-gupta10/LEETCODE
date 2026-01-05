class Solution {
    int ans=Integer.MAX_VALUE;
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int ans=Integer.MAX_VALUE;
        Queue<pair> q=new LinkedList<>();
        int[] row={1,-1,0,0};
        int[] col={0,0,1,-1};
        q.add(new pair(0,0,0));
        int[][] dis=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dis[i],Integer.MAX_VALUE);
        }
        dis[0][0]=0;
        while(!q.isEmpty()){
            pair rp=q.poll();
            if(rp.r==n-1&&rp.c==m-1){
                ans=Math.min(ans,rp.dif);
            }
            for(int i=0;i<4;i++){
                int newr=rp.r+row[i];
                int newc=rp.c+col[i];
                if(newr<0||newc<0||newr>=n||newc>=m){
                    continue;
                }
                int dif=Math.abs(heights[rp.r][rp.c]-heights[newr][newc]);
                dif=Math.max(dif,rp.dif);
                if(dis[newr][newc]>dif){
                    dis[newr][newc]=dif;
                    q.add(new pair(dif,newr,newc));
                }
                
            }
        }
        return dis[n-1][m-1];
        
    }
    
}
class pair{
    int dif;
    int r;
    int c;
    public pair(int dif,int r,int c){
        this.dif=dif;
        this.r=r;
        this.c=c;
    }
}