class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n=graph.length;
        List<Integer> ls=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        paths(graph,ls,ans,0,n-1);
        return ans;
    }
    public void paths(int[][] graph,List<Integer> ls,List<List<Integer>> ans,int src,int des){
        if(src==des){
            ls.add(src);
            ans.add(new ArrayList<>(ls));
            ls.remove(ls.size()-1);
            return;
        }
        
        for(int nb:graph[src]){
            
                ls.add(src);
                paths(graph,ls,ans,nb,des);
                ls.remove(ls.size()-1);
            
        }
        
    }
}