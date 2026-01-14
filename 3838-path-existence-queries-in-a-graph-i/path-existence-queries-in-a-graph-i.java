class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int q=queries.length;
        boolean[] ans=new boolean[q];
        int[] ar=new int[n];
        for(int i=1;i<n;i++){
            int dif=Math.abs(nums[i]-nums[i-1]);
            ar[i]=ar[i-1]+(dif>maxDiff?1:0);
        }
        for(int i=0;i<q;i++){
            int u=queries[i][0];
            int v=queries[i][1];
            int st=Math.min(u,v);
            int end=Math.max(u,v);
            if(ar[end]-ar[st]==0){
                ans[i]=true;
            }
        }
        return ans;
    }
}