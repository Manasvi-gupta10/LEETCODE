class Solution {
    public void rotate(int[][] matrix) {
        int r=matrix.length;
        int c=matrix[0].length;
        for(int i=0;i<r;i++){
            for(int j=i;j<c;j++){
                int t=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=t;
            }
        }
        for(int i=0;i<r;i++){
            rev(matrix,i,0,c-1);
        }
    }
    public void rev(int[][] matrix,int r,int i,int j){
        while(i<=j){
            int t=matrix[r][i];
                matrix[r][i]=matrix[r][j];
                matrix[r][j]=t;
                i++;
                j--;
        }
    }
}