class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        //ls is reverse of edges ek type se
        List<List<Integer>> ls=new ArrayList<>();//ls m wo list of edges hongi ith p jha se m i pe aaskti
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
        //terminal vertexes safe hote hi as wha s koi edges ni aur toh wha se us wle terminal p jaa skte
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
                out[nb]--;//t wla safe hai aur nb->t wla hta skte
                if(out[nb]==0){
                    q.add(nb);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}