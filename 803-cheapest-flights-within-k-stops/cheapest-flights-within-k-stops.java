class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer,HashMap<Integer,Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new HashMap<>());
        }
        int l=flights.length;
        for(int i=0;i<l;i++){
            int u=flights[i][0];
            int v=flights[i][1];
            int w=flights[i][2];
            map.get(u).put(v,w);

        }
        int ans=Integer.MAX_VALUE;
        int[][] dis=new int[n][k+2];
        for(int i=0;i<dis.length;i++){
            Arrays.fill(dis[i],Integer.MAX_VALUE);
        }
        Queue<pair> pq=new LinkedList<>();
        pq.add(new pair(src,-1,0));
        dis[src][0]=0;
        while(!pq.isEmpty()){
            pair r=pq.poll();
            if (r.cost >= ans) continue;
            if(r.stops>k){
                continue;
            }
            if(r.val==dst){
                ans=Math.min(r.cost,ans);
                continue;
            }
           
            if (r.stops == k) continue;

            
            for(int nb:map.get(r.val).keySet()){
                int c=map.get(r.val).get(nb);
                int newc=r.cost+c;
                int stops=r.stops+1;
                if(stops+1>=k+2){
                    continue;
                }
                if(newc<dis[nb][stops+1]){
                    dis[nb][stops+1]=newc;
                    pq.add(new pair(nb,stops,newc));

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
    int stops;
    int cost;
    public pair(int val,int stops,int cost){
        this.val=val;
        this.stops=stops;
        this.cost=cost;

    }
}
