class Solution {
    public int minStoneSum(int[] piles, int k) {
        int n=piles.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            pq.add(piles[i]);
        }
        for(int i=0;i<k;i++){
            int v=pq.poll();
            int up=(int)Math.ceil((double)(v/2));
            v=v-up;
            pq.add(v);
        }
        int ans=0;
        while(!pq.isEmpty()){
            ans+=pq.poll();
        }
        return ans;
    }
}