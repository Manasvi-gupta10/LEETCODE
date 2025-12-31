class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ls=new ArrayList<>();
        paths(graph,ls,ans,0,graph.length-1,new HashSet<Integer>());
        return ans;

        
    }
    public void paths(int[][] edges,List<Integer> ls,List<List<Integer>> ans,int src,int des,HashSet<Integer> set){
        if(src==des){
            ls.add(src);
            ans.add(new ArrayList<>(ls));
            ls.remove(ls.size()-1);
            return;
        }

        set.add(src);
        
        for(int nb:edges[src]){
            if(!set.contains(nb)){
                ls.add(src);
                paths(edges,ls,ans,nb,des,set);
                ls.remove(ls.size()-1);
            }
        }
        
        set.remove(src);
    }
}