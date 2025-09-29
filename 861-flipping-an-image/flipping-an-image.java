class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int row=image.length;
        int col=image[0].length;
        for(int i=0;i<row;i++){
            reverse(0,col-1,image,i);
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(image[i][j]==0){
                    image[i][j]=1;
                }else{
                    image[i][j]=0;
                }
            }
        }
        return image;
    }
    public void reverse(int i,int j,int[][] ar,int r){
       while(i<j){
           int t=ar[r][i];
           ar[r][i]=ar[r][j];
           ar[r][j]=t;
           i++;
           j--;
       }
   }
}