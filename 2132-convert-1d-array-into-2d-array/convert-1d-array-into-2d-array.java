class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int l=original.length;
        if(m*n!=l){
            return new int[0][0];
        }
        int[][] ar=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ar[i][j]=original[i*n+j];
            }
        }
        return ar;
    }
}