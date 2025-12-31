class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer,HashMap<Integer,Integer>> map=new HashMap<>();
        int l=times.length;
        for(int i=1;i<=n;i++){
            map.put(i,new HashMap<>());
        }
        for(int i=0;i<l;i++){
            int u=times[i][0];
            int v=times[i][1];
            int w=times[i][2];
            map.get(u).put(v,w);

        }
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        HashSet<Integer> set=new HashSet<>();
        int ans=0;
        int cn=0;
        pq.add(new pair(k,0));
        while(!pq.isEmpty()){
            pair r=pq.poll();
            if(set.contains(r.val)){
                continue;
            }
            set.add(r.val);
            ans=Math.max(ans,r.cost);
            cn++;
            for(int nb:map.get(r.val).keySet()){
                if(!set.contains(nb)){
                    int c=map.get(r.val).get(nb);
                    pq.add(new pair(nb,r.cost+c));
                }
            }
        }
        if(cn!=n){
            return -1;
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