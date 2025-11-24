class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        int ln=edges.length;
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<Integer>());
        }
        for(int i=0;i<ln;i++){
            int v1=edges[i][0];
            int v2=edges[i][1];
            map.get(v1).add(v2);
            map.get(v2).add(v1);
        }
        int c=0;
        HashSet<Integer> set=new HashSet<>();
        Queue<Integer> q=new LinkedList<>();
        for(int v:map.keySet()){
            if(set.contains(v)){
                continue;
            }
            List<Integer> comp = new ArrayList<>();
            q.add(v);
            while(!q.isEmpty()){
                int r=q.poll();
                if(set.contains(r)){
                    continue;
                }
                set.add(r);
                comp.add(r);
                for(int nb:map.get(r)){
                    if(!set.contains(nb)){
                        q.add(nb);
                    }
                }
            }
            int k = comp.size();
            int totalEdges = 0;

            for(int node : comp){
                totalEdges += map.get(node).size();
            }
            totalEdges /= 2;  

            if(totalEdges == k * (k - 1) / 2){
                c++;
            }

        }
        return c;
    }
}