class Solution {
    public int numIslands(char[][] grid) {
        int ans=0;
        int n=grid.length;
        int m=grid[0].length;
       // boolean[][] visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    ans++;
                    dfs(grid,i,j);
                }
            }
        }
        return ans;
    }
    public void dfs(char[][] ar,int i,int j){

       if(i<0||j<0||i>=ar.length||j>=ar[0].length||ar[i][j]=='0'){
        return;
       }
        ar[i][j]='0';
        dfs(ar,i+1,j);
        dfs(ar,i-1,j);
        dfs(ar,i,j+1);
        dfs(ar,i,j-1);
    }
}