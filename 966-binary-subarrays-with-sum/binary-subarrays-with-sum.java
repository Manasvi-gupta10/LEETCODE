class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        map.put(0,1);
        int ans=0;
        for(int num:nums){
            sum+=num;
            int req=sum-goal;
            ans+=map.getOrDefault(req,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}