class NumMatrix {
    int[][] pr;
    public NumMatrix(int[][] matrix) {
        int r=matrix.length;
        int c=matrix[0].length;
        pr=new int[r][c];
        for(int i=0;i<r;i++){
            pr[i][0]=matrix[i][0];
        }
        for(int i=0;i<r;i++){
            for(int j=1;j<c;j++){
                pr[i][j]=pr[i][j-1]+matrix[i][j];
            }
        }

    }
    
    public int sumRegion(int r1, int c1, int r2, int c2) {
        int ans=0;
        for(int i=r1;i<=r2;i++){
            if(c1==0){
                ans+=pr[i][c2];
            }else{
                ans+=pr[i][c2]-pr[i][c1-1];
            }
        }
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */