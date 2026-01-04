class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visit=new boolean[image.length][image[0].length];
        dfs(image,sr,sc,color,image[sr][sc],visit);
        return image;
    }
    public void dfs(int[][] grid,int sr,int sc,int color,int prevcolor,boolean[][] visit){
        if(sr<0||sc<0||sr>=grid.length||sc>=grid[0].length||grid[sr][sc]!=prevcolor||visit[sr][sc]==true){
            return;
        }
        visit[sr][sc]=true;
        grid[sr][sc]=color;
        dfs(grid,sr+1,sc,color,prevcolor,visit);
        dfs(grid,sr,sc+1,color,prevcolor,visit);
        dfs(grid,sr-1,sc,color,prevcolor,visit);
        dfs(grid,sr,sc-1,color,prevcolor,visit);


    }
}