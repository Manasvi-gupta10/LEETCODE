class Solution {
    public int minCost(int n, int[][] edges) {
        HashMap<Integer,HashMap<Integer,Integer>> map=new HashMap<>();
        int l=edges.length;
        for(int i=0;i<n;i++){
            map.put(i,new HashMap<>());
        }
        for(int i=0;i<l;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int cost=edges[i][2];
            if(map.get(u).containsKey(v)){
                cost=Math.min(cost,map.get(u).get(v));
                map.get(u).put(v,cost);
            }
            else{
                map.get(u).put(v,cost);
            }
             if(map.get(v).containsKey(u)){
                cost=Math.min(2*cost,map.get(v).get(u));
                map.get(v).put(u,cost);
            }
            else{
                map.get(v).put(u,2*cost);
            }
            
        }
        int ans=-1;
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        HashSet<Integer> set=new HashSet<>();
        pq.add(new pair(0,0));
        while(!pq.isEmpty()){
            pair rp=pq.poll();
            if(set.contains(rp.val)){
                continue;
            }
            set.add(rp.val);
            if(rp.val==n-1){
                ans=rp.cost;
            }
            for(int nb:map.get(rp.val).keySet()){
                if(!set.contains(nb)){
                    int c=map.get(rp.val).get(nb);
                    pq.add(new pair(nb,rp.cost+c));
                }
            }


        }
        return ans;

        
    }
}
class pair{
    int val;
    int cost;
    public pair(int val,int cost){
        this.val=val;
        this.cost=cost;
    }
}