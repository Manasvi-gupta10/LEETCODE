class Solution {
    public int countRestrictedPaths(int n, int[][] edges) {
        HashMap<Integer,HashMap<Integer,Integer>> map=new HashMap<>();
        int l=edges.length;
        for(int i=1;i<=n;i++){
            map.put(i,new HashMap<>());
        }
        for(int i=0;i<l;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];
            map.get(u).put(v,w);
            map.get(v).put(u,w);

        }
        int[] dis=new int[n+1];
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.add(new pair(n,0));
        HashSet<Integer> set=new HashSet<>();
        while(!pq.isEmpty()){
            pair r=pq.poll();
            if(set.contains(r.val)){
                continue;
            }
            set.add(r.val);
            dis[r.val]=r.cost;
            for(int k:map.get(r.val).keySet()){
                if(!set.contains(k)){
                    int c=map.get(r.val).get(k);
                    pq.add(new pair(k,r.cost+c));
                }
            }
        }
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        restrict(1,n,map,dp,dis);
        return dp[1];    
    }
    public int restrict(int u,int n,HashMap<Integer,HashMap<Integer,Integer>> map,int[] dp,int[] dis){
        if(u==n){
            return 1;
        }
        if(dp[u]!=-1){
            return dp[u];

        }
        long w=0;
        for(int v:map.get(u).keySet()){
            if(dis[v]<dis[u]){
                w=(w+restrict(v,n,map,dp,dis))%1000000007;
            }
        }
        dp[u]=(int)w;
        return dp[u];
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