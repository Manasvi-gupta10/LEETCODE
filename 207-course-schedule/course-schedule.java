class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<numCourses;i++){
            map.put(i,new ArrayList<>());
        }
        for(int[] a:prerequisites){
            map.get(a[1]).add(a[0]);
        }
        int[] ind=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int nb:map.get(i)){
                ind[nb]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(ind[i]==0){
                q.add(i);
            }
        }
        int c=0;
        while(!q.isEmpty()){
            int r=q.poll();
            c++;
            for(int nb:map.get(r)){
                ind[nb]--;
                if(ind[nb]==0){
                    q.add(nb);
                }
            }
        }
        return c==numCourses;
    }
}