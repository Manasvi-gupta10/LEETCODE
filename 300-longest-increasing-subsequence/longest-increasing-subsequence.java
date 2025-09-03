class Solution {
    public int lengthOfLIS(int[] nums) {
        return lis(nums);
    }
    public static int lis(int[] ar){
        int[] dp=new int[ar.length];
        Arrays.fill(dp,1);
        for(int i=1;i<ar.length;i++){
            for(int j=i-1;j>=0;j--){
                if(ar[i]>ar[j]){
                    int x=dp[j];
                    dp[i]=Math.max(dp[i],x+1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}