class Solution {
    public int numIslands(char[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        int ans=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='1'){
                    ans++;
                    dfs(grid,i,j);
                }
            }
        }
        return ans;
    }
    public void dfs(char[][] ar,int r,int c){
        if(r<0||c<0||r>=ar.length||c>=ar[0].length||ar[r][c]=='0'){
            return;
        }

        ar[r][c]='0';
        dfs(ar,r+1,c);
        dfs(ar,r,c+1);
        dfs(ar,r-1,c);
        dfs(ar,r,c-1);
    }
}