class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        HashMap<Integer,HashMap<Integer,Integer>> map=new HashMap<>();
        int n=passingFees.length;
        for(int i=0;i<n;i++){
            map.put(i,new HashMap<>());
        }
        for(int i=0;i<edges.length;i++){
        int u=edges[i][0];
        int v=edges[i][1];
        int w=edges[i][2];
      map.get(u).put(
    v,
    Math.min(map.get(u).getOrDefault(v, Integer.MAX_VALUE), w));
        map.get(v).put(
    u,
    Math.min(map.get(v).getOrDefault(u, Integer.MAX_VALUE), w));
    } 
        int ans=Integer.MAX_VALUE;
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        int[] mintime=new int[n];
        Arrays.fill(mintime,Integer.MAX_VALUE);
        pq.add(new pair(0,0,passingFees[0]));
        while(!pq.isEmpty()){
            pair rp=pq.poll();
            
            if(rp.time>maxTime||rp.time>=mintime[rp.val]){
                continue;
            }
            
            if(rp.val==n-1&&rp.time<=maxTime){
                ans=Math.min(ans,rp.cost);
            }
            mintime[rp.val]=rp.time;
            for(int k:map.get(rp.val).keySet()){
                
                    int tm=map.get(rp.val).get(k);
                    if(tm+rp.time<=maxTime){
                        pq.add(new pair(k,rp.time+tm,rp.cost+passingFees[k]));
                    }
                

            }
        }
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
}
class pair{
    int val;
    int time;
    int cost;
    public pair(int val,int time,int cost){
        this.val=val;
        this.time=time;
        this.cost=cost;
    }
}