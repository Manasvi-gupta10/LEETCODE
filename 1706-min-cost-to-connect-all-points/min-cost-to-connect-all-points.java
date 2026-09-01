class Solution {
    class pair{
        int v;
        int cost;
        public pair(int v,int cost){
            this.v=v;
            this.cost=cost;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        HashMap<Integer,HashMap<Integer,Integer>> map=new HashMap<>();
        int n=points.length;
        for(int i=0;i<n;i++){
            map.put(i,new HashMap<>());
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int cost=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                map.get(i).put(j,cost);
                map.get(j).put(i,cost);
            }
        }
        int mst=0;
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        HashSet<Integer> set=new HashSet<>();
        pq.add(new pair(0,0));
        while(!pq.isEmpty()){
            pair rp=pq.poll();
            if(set.contains(rp.v)){
                continue;
            }
            set.add(rp.v);
            mst+=rp.cost;
            for(int nb:map.get(rp.v).keySet()){
                if(!set.contains(nb)){
                    int c=map.get(rp.v).get(nb);
                    pq.add(new pair(nb,c));
                }

            }
        }
        return mst;
        
    }
}