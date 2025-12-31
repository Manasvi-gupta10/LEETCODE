class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> ls=new ArrayList<>();
        int n=graph.length;
        for(int i=0;i<n;i++){
            ls.add(new ArrayList<>());
        }
        int[] out=new int[n];
        for(int i=0;i<n;i++){
            for(int j:graph[i]){
                out[i]++;
                ls.get(j).add(i);
            }
            
        }
        List<Integer> ans=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(out[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int t=q.poll();
            ans.add(t);
            for(int nb:ls.get(t)){
                out[nb]--;
                if(out[nb]==0){
                    q.add(nb);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}