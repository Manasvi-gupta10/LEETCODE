class Solution {
    public int uniquePathsIII(int[][] grid) {
        int ans=0;
        boolean isneg=false;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==-1){
                   isneg=true;
                }
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return paths(grid,i,j,0,isneg);
                }
            }
        }
        return ans;
    }
    public int paths(int[][] path,int i,int j,int z,boolean isneg){
        
        if(i<0||j<0||i>=path.length||j>=path[0].length||path[i][j]==-1){
            return 0;
        }
        if(path[i][j]==2){
            if(isneg&&(z==(path.length*path[0].length-2))){
               return 1;
            }
            else if(!isneg&&(z==(path.length*path[0].length-1))){
               return 1;
            }
            
            return 0;
        }
        path[i][j]=-1;
        int[] r={1,-1,0,0};
        int[] c={0,0,1,-1};
        int ans=0;
        for(int k=0;k<4;k++){
            ans+=paths(path,i+r[k],j+c[k],z+1,isneg);
        }
        path[i][j]=0;
        return ans;
    }
}