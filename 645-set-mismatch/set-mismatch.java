class Solution {
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;
        int[] fr=new int[n+1];
        for(int i=0;i<n;i++){
            fr[nums[i]]++;
        }
        int[] ans=new int[2];
        for(int i=1;i<=n;i++){
            if(fr[i]==2){
                ans[0]=i;
            }else if(fr[i]==0){
                ans[1]=i;
            }
        }
        return ans;
    }
}