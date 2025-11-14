class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] ar=new int[n][n];
        int q=queries.length;
        for(int i=0;i<q;i++){
            inc(ar,queries[i][0],queries[i][1],queries[i][2],queries[i][3]);
        }
        return ar;
    }
    public void inc(int[][] ar,int r1,int c1,int r2,int c2){
        for(int i=r1;i<=r2;i++){
            for(int j=c1;j<=c2;j++){
                ar[i][j]++;
            }
        }
    }
}