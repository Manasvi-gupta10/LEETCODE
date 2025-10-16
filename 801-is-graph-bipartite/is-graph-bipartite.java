class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<bipartpair> q=new LinkedList<>();
        HashMap<Integer,Integer> visited=new HashMap<>();
        for(int i=0;i<graph.length;i++){
            if(visited.containsKey(i)){
                continue;
            }
            q.add(new bipartpair(i,0));
            while(!q.isEmpty()){
                //1
                bipartpair b=q.poll();
                //2
                if(visited.containsKey(b.vtx)){
                    if(visited.get(b.vtx)!=b.dis){
                        return false;
                    }
                    continue;
                }
                //3
                visited.put(b.vtx,b.dis);
                //4
                //5
                for(int j:graph[b.vtx]){
                    if(!visited.containsKey(j)){
                        q.add(new bipartpair(j,b.dis+1));
                    }
                }
            }
        }
        return true;
    }
}
class bipartpair{
    int vtx;
    int dis;
    public bipartpair(int vtx,int dis){
        this.vtx=vtx;
        this.dis=dis;
    }
}