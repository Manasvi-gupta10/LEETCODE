class Solution {
    public int minOperations(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<Long> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add((long)nums[i]);
        }
        int ans=0;
        while(pq.size()>=2&&pq.peek()<k){
            long x=pq.poll();
            long y=pq.poll();
            pq.add(x*2+y);
            ans++;
        }
        return ans;
    }
}