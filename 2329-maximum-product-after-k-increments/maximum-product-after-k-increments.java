class Solution {
    public int maximumProduct(int[] nums, int k) {
        int mod=1000000007;
        int n=nums.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int i=0;i<n;i++){
            pq.add(nums[i]);
        }
        for(int i=0;i<k;i++){
            int e=pq.poll();//small no.hoga usko badayenge taki product maximum ho
            pq.add(e+1);
        }
        long ans=1;
        while(!pq.isEmpty()){
            ans=(ans*pq.poll())%mod;
        }
        return (int)ans;
    }
}