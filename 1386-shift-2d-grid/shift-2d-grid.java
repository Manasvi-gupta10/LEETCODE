class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        int r=grid.length;
        int c=grid[0].length;
        while(k-->0){
            List<Integer> ls=new ArrayList<>();
            for(int i=0;i<r;i++){
                ls.add(grid[i][c-1]);
            }
            int last=grid[r-1][c-1];
            for(int i=0;i<r;i++){
                for(int j=c-1;j>0;j--){
                    grid[i][j]=grid[i][j-1];
                }
            }
            grid[0][0]=last;
            for(int i=1;i<r;i++){
                grid[i][0]=ls.get(i-1);
            }
        }
        for(int i=0;i<r;i++){
            List<Integer> l=new ArrayList<>();
            for(int j=0;j<c;j++){
                l.add(grid[i][j]);
            }
            ans.add(l);
        }
        return ans;
    }
}