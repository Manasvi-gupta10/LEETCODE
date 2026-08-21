class Solution {
    public int subarraySum(int[] nums, int k) {
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