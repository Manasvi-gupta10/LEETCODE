class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int r=isWater.length;
        int c=isWater[0].length;
        int[][] ans=new int[r][c];
        for(int i=0;i<r;i++){
            Arrays.fill(ans[i],Integer.MAX_VALUE);
        }
        Queue<pair> q=new LinkedList<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(isWater[i][j]==1){
                    ans[i][j]=0;
                    q.add(new pair(i,j,0));
                }
            }
        }
        int[] row={0,0,1,-1};
        int[] col={1,-1,0,0};
        while(!q.isEmpty()){
            pair rp=q.poll();
            
            for(int i=0;i<4;i++){
                int newr=rp.r+row[i];
                int newc=rp.c+col[i];
                if(newr<0||newc<0||newr>=r||newc>=c){
                    continue;
                }
                if(ans[newr][newc]>rp.ht+1){
                    ans[newr][newc]=rp.ht+1;
                    q.add(new pair(newr,newc,rp.ht+1));
                }
            }

        }
        return ans;
    }
}
class pair{
    int r;
    int c;
    int ht;
    public pair(int r,int c,int ht){
        this.r=r;
        this.c=c;
        this.ht=ht;
    }

}