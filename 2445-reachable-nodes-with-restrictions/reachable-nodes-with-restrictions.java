class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        for(int i=0;i<restricted.length;i++){
            set.add(restricted[i]);

        }
        int ans=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int t=q.poll();
            if(set.contains(t)){
                continue;
            }
            set.add(t);
            ans++;
            for(int k:map.get(t)){
                if(!set.contains(k)){
                    q.add(k);
                }
            }
        }
        return ans;
    }
}