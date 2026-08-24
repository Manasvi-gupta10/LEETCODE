class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        map.put(0,1);
        int ans=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int req=sum-k;
            ans+=map.getOrDefault(req,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
        
    }
}




