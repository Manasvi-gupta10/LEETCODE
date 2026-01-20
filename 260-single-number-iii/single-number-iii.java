class Solution {
    public int[] singleNumber(int[] nums) {
        int n=nums.length;
        int ex=0;
        for(int i=0;i<n;i++){
            ex^=nums[i];

        }
        int mask=(ex&(~(ex-1)));
        int a=0;
        for(int i=0;i<n;i++){
            if((nums[i]&mask)==0){
                a^=nums[i];
            }
        }
        int b=a^ex;
        int[] ans=new int[2];
        ans[0]=a;
        ans[1]=b;
        return ans;
    }
}