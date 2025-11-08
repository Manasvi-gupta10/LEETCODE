class Solution {
    public int[] findBall(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[] ans=new int[m];
        
            for(int j=0;j<m;j++){
                int col=status(grid,0,j);
                if(col<0||col>=m){
                    ans[j]=-1;
                    
                }else{
                    ans[j]=col;
                }
            }
        
        return ans;
    }
    public int status(int[][] grid,int i,int j){
        int n=grid.length;
        int m=grid[0].length;
        int cur=j;
        for(int x=i;x<grid.length;x++){
            int y=cur;
            if(y<m&&y>=0){
                if(grid[x][y]==1){
                    if(y+1<m&&grid[x][y+1]==-1){
                        return -1;
                    }else{
                        cur=y+1;
                    }
                }else if(grid[x][y]==-1){
                    if(y-1>-1&&grid[x][y-1]==1){
                        return -1;
                    }else{
                        cur=y-1;
                    }
                }
            }
            
        }
        return cur;
    }
}