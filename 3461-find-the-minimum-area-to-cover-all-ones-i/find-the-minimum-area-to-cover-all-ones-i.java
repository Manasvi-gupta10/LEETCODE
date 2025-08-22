class Solution {
    public int minimumArea(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        ArrayList<Integer> ls=new ArrayList<>();
        for(int i=0;i<n;i++){
            boolean isone=false;
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    isone=true;
                }
            }
            if(isone){
                ls.add(i);
            }
        }
        int h=ls.get(ls.size()-1)-ls.get(0)+1;
        ls.clear();
        for(int i=0;i<m;i++){
            boolean isone=false;
            for(int j=0;j<n;j++){
                if(grid[j][i]==1){
                    isone=true;
                }
            }
            if(isone){
                ls.add(i);
            }
        }
        int w=ls.get(ls.size()-1)-ls.get(0)+1;
        return h*w;
    }
}