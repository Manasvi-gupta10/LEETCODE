class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int v1=edges[i][0];
            int v2=edges[i][1];
            map.get(v1).add(v2);
            map.get(v2).add(v1);
        }
        HashSet<Integer> set=new HashSet<>();
        return path(map,source,destination,set);
    }
    public boolean path(HashMap<Integer,ArrayList<Integer>> map,int src,int des,HashSet<Integer> visited){
        if(src==des){
            return true;
        }
        visited.add(src);
        for(int nbr:map.get(src)){
           if(!visited.contains(nbr)){
             boolean ans=path(map,nbr,des,visited);
            if(ans){
                return ans;
            }
           }
        }
        return false;
    }
}