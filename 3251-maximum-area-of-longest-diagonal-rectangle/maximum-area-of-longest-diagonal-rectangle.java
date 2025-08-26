class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int n=dimensions.length;
        int ans=0;
        double diag=0;
        for(int i=0;i<n;i++){
            int l=dimensions[i][0];
            int b=dimensions[i][1];
            double d=Math.sqrt(((l*l)+(b*b)));
            if(d>diag){
                diag=d;
                ans=l*b;
            }else if(d==diag){
                ans=Math.max(ans,l*b);
            }
        }
        return ans;
    }
}