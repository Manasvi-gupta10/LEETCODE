class Solution {
    public long maxTotal(int[] value, int[] limit) {
        int n=value.length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]){
                return b[1]-a[1];
            }else{
                return a[0]-b[0];
            }
        });
        for(int i=0;i<n;i++){
            int[] nn={limit[i],value[i]};
            pq.add(nn);
        }
        long ans=0;
        int act=0;
        PriorityQueue<int[]> ac=new PriorityQueue<>((a,b)->a[0]-b[0]);
        while(!pq.isEmpty()){
            if(act<pq.peek()[0]){
                act++;
                ans+=pq.peek()[1];
                ac.add(pq.poll());
                while(!pq.isEmpty()&&act>=pq.peek()[0]){
                    pq.poll();
                }
                while(!ac.isEmpty()&&act>=ac.peek()[0]){
                    act--;
                    ac.poll();
                }
            }

        }
        return ans;
    }
}