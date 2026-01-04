class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int r=mat.length;
        int c=mat[0].length;
        int[][] ans=new int[r][c];
        int[] row={0,0,1,-1};
        int[] col={-1,1,0,0};
        Queue<pair> q=new LinkedList<>();

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i][j]==0){
                    q.add(new pair(i,j));

                }else{
                    ans[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        while(!q.isEmpty()){
            pair rp=q.poll();

            for(int i=0;i<4;i++){
                int newr=rp.r+row[i];
                int newc=rp.c+col[i];
                if(newr<0||newc<0||newr>=r||newc>=c){
                    continue;
                }
                if(ans[newr][newc]>ans[rp.r][rp.c]+1){
                    ans[newr][newc]=ans[rp.r][rp.c]+1;
                    q.add(new pair(newr,newc));
                }
            }
            
        }
        return ans;
    }
    
}
class pair{
   
    int r;
    int c;
    
    public pair(int r,int c){
       
        this.r=r;
        this.c=c;
        
    }
}