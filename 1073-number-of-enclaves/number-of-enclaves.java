class Solution {
    public int numEnclaves(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        for(int i=0;i<r;i++){
            if(grid[i][0]==1){
                dfs(grid,i,0);
            }
            if(grid[i][c-1]==1){
                dfs(grid,i,c-1);
            }
        }
        for(int i=0;i<c;i++){
            if(grid[0][i]==1){
                dfs(grid,0,i);
            }if(grid[r-1][i]==1){
                dfs(grid,r-1,i);
            }
        }
        int ans=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]==1){
                    ans++;
                }
            }
        }
        return ans;
        
    }
    public void dfs(int[][] ar,int i,int j){
        if(i<0||j<0||i>=ar.length||j>=ar[0].length||ar[i][j]!=1){
            return;
        }

        ar[i][j]=0;
        dfs(ar,i-1,j);
        dfs(ar,i,j-1);
        dfs(ar,i+1,j);
        dfs(ar,i,j+1);

    }
}