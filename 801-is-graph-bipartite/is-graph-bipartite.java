class Solution {
    public boolean isBipartite(int[][] graph) {
        HashMap<Integer,Integer> visited=new HashMap<>();
        Queue<pair> q=new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            if(visited.containsKey(i)){
                continue;
            }
            q.add(new pair(i,0));
            while(!q.isEmpty()){
                pair r=q.poll();
                if(visited.containsKey(r.vtx)){
                    if(visited.get(r.vtx)!=r.dis){
                        return false;
                    }else{
                        continue;
                    }
                }
                visited.put(r.vtx,r.dis);
                for(int nbr:graph[r.vtx]){
                    if(!visited.containsKey(nbr)){
                        q.add(new pair(nbr,r.dis+1));
                    }
                }
            }
        }
        return true;
    }
}
class pair{
    int vtx;
    int dis;
    public pair(int vtx,int dis){
        this.vtx=vtx;
        this.dis=dis;
    }
}