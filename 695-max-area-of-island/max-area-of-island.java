class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    ans=Math.max(ans,islands(grid,i,j));
                }
            }
        }
        return ans;
        
    }
    public int islands(int[][] grid,int i,int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]==0){
            return 0;
        }

        grid[i][j]=0;
        int d1=islands(grid,i+1,j);
        int d2=islands(grid,i,j+1);
        int d3=islands(grid,i-1,j);
        int d4=islands(grid,i,j-1);
        return d1+d2+d3+d4+1;
    }
}