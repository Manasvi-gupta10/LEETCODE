class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int prev=image[sr][sc];
        if (prev == color) return image;
        int r=image.length;
        int c=image[0].length;
        fill(image,sr,sc,color,image[sr][sc]);
        return image;

    }
    public void fill(int[][] ar,int r,int c,int col,int prev){
        if(r<0||c<0||r>=ar.length||c>=ar[0].length||ar[r][c]!=prev){
            return;
        }
        ar[r][c]=col;
        fill(ar,r+1,c,col,prev);
        fill(ar,r,c+1,col,prev);
        fill(ar,r-1,c,col,prev);
        
        fill(ar,r,c-1,col,prev);
    }
}