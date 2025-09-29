class Solution {
    public List<Integer> luckyNumbers(int[][] mat) {
        List<Integer> ans=new ArrayList<>();
        HashSet<Integer> row=new HashSet<>();
        HashSet<Integer> col=new HashSet<>();
        for(int i=0;i<mat.length;i++){
            int mn=Integer.MAX_VALUE;
            for(int j=0;j<mat[0].length;j++){
                mn=Math.min(mn,mat[i][j]);
            }
            row.add(mn);
        }
        for(int i=0;i<mat[0].length;i++){
            int mx=0;
            for(int j=0;j<mat.length;j++){
                mx=Math.max(mx,mat[j][i]);
            }
            col.add(mx);
        }
        for(int i:row){
            if(col.contains(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}