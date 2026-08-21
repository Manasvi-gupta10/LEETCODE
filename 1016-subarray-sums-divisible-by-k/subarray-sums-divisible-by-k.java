class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int ans=0;
        map.put(0,1);
        for(int n:nums){
            sum+=n;
            int rem=sum%k;
             if (rem < 0) {
        rem += k;
    }
            ans+=map.getOrDefault(rem,0);
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return ans;
    }
}