class Solution {
    public int countNegatives(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        int ans=0;
        for(int i=0;i<r;i++){
            int pc=-1;
            for(int j=0;j<c;j++){
                if(grid[i][j]<0){
                    pc=j;
                    break;
                }

            }
            if(pc!=-1){
                ans+=(c-pc);
            }
        }
        return ans;
        
    }
}