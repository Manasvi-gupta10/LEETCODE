class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n=prerequisites.length;
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<numCourses;i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            int a=prerequisites[i][0];
            int b=prerequisites[i][1];
            map.get(b).add(a);
        }
        int[] ind=new int[numCourses];
        for(int v:map.keySet()){
            for(int nb:map.get(v)){
                ind[nb]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<ind.length;i++){
            if(ind[i]==0){
                q.add(i);
            }
        }
        int[] ans=new int[numCourses];
        int in=0;
        int c=0;
        while(!q.isEmpty()){
            int r=q.poll();
            ans[in++]=r;
            c++;
            for(int nb:map.get(r)){
                ind[nb]--;
                if(ind[nb]==0){
                    q.add(nb);
                }
            }
        }
        if(c!=map.size()){
            return new int[0];
        }
        return ans;
    }
}