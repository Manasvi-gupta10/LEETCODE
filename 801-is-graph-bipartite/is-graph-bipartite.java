class Solution {
    class pair{
        int v;
        int cost;
        public pair(int v,int cost){
            this.v=v;
            this.cost=cost;
        }
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        HashMap<Integer,Integer> visit=new HashMap<>();
        Queue<pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(visit.containsKey(i)){
                continue;
            }
            q.add(new pair(i,0));
        while(!q.isEmpty()){
            pair rp=q.poll();
            if(visit.containsKey(rp.v)){
                if(rp.cost!=visit.get(rp.v)){
                    return false;
                }
                continue;
            }
            visit.put(rp.v,rp.cost);
            for(int nb:graph[rp.v]){
                if(!visit.containsKey(nb)){
                    q.add(new pair(nb,rp.cost+1));
                }
            }
        }
        }
        return true;

    }
}