class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        HashMap<Integer,HashMap<Integer,Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new HashMap<>());
        }
        int l=edges.length;
        for(int i=0;i<l;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];
            if(map.get(u).containsKey(v)){
                int w1=Math.min(map.get(u).get(v),w);
                map.get(u).put(v,w1);
            }else{
                map.get(u).put(v,w);
            }
            if(map.get(v).containsKey(u)){
                int w1=Math.min(map.get(v).get(u),w);
                map.get(v).put(u,w1);
            }else{
                map.get(v).put(u,w);
            }
            

        }
        HashSet<Integer> set=new HashSet<>();
        int[] ans=new int[n];
        Arrays.fill(ans,-1);
        PriorityQueue<pair> q=new PriorityQueue<>((a,b)->a.cost-b.cost);
        
        q.add(new pair(0,0));
        while(!q.isEmpty()){
            pair r=q.poll();
            if(r.cost>=disappear[r.val]){
                continue;
            }
            if(set.contains(r.val)){
                continue;
            }
           
            set.add(r.val);
            
            ans[r.val]=r.cost;
            for(int k:map.get(r.val).keySet()){
                if(!set.contains(k)){
                    int c=map.get(r.val).get(k);
                    q.add(new pair(k,r.cost+c));

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