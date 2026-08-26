class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ans=0;
        int c=matrix[0].length;
        int r=matrix.length;
        int[] ar=new int[c];
        for(int i=0;i<r;i++){
            ar=new int[c];
            for(int j=i;j<r;j++){
                for(int k=0;k<c;k++){
                    ar[k]+=matrix[j][k];

                }
                ans+=sum(ar,target);
            }
        }
        return ans;
    }
    public int sum(int[] nums, int k) {
        //int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int ans=0;
        map.put(0,1);
        for(int n:nums){
            sum+=n;
            int req=sum-k;
            ans+=map.getOrDefault(req,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}