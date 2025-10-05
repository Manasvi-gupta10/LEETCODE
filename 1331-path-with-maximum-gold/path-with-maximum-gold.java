class Solution {
    public int getMaximumGold(int[][] grid) {
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                ans=Math.max(ans,maxgold(i,j,grid));
            }
        }
        return ans;
    }
    public int maxgold(int i,int j,int[][] grid){
       
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]==0){
            return 0;
        }
        int gold=grid[i][j];
        grid[i][j]=0;
        int maxg=0;
        int[] r={1,-1,0,0};
        int[] c={0,0,1,-1};
        for(int k=0;k<4;k++){
            maxg=Math.max(maxg,maxgold(i+r[k],j+c[k],grid));
        }
        grid[i][j]=gold;
        return maxg+gold;
    }
}