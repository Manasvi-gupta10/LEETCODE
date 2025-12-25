class Solution {
    public int countNicePairs(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            int rv=rev(nums[i]);
            nums[i]=nums[i]-rv;
        }
        HashMap<Integer,Long> map=new HashMap<>();
        long ans=0;
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                ans=(ans+map.get(nums[i]))%1000000007;
            }
            map.put(nums[i],map.getOrDefault(nums[i],0L)+1);
        }
        return (int)ans%1000000007;
    }
    public int rev(int e) {
    int ans = 0;
    while (e > 0) {
        ans = ans * 10 + (e % 10);
        e /= 10;
    }
    return ans;
}

}