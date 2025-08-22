class Solution {
    public long maxKelements(int[] nums, int k) {
        int n=nums.length;
        long ans=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            pq.add(nums[i]);
        }
        for(int i=0;i<k;i++){
            int el=pq.poll();
            ans+=el;
            pq.add((int)Math.ceil(el / 3.0));

        }
        return ans;
    }
}