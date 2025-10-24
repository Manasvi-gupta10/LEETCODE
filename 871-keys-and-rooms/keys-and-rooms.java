class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //keys are telling ki is room se kin rooms m ja skte mtlb neighbours hi
        int n=rooms.size();
        HashSet<Integer> visited=new HashSet<>();
        Queue<Integer> q=new LinkedList<>();
        int c=0;
        for(int i=0;i<n;i++){
            if(visited.contains(i)){
                continue;
            }
            c++;
            q.add(i);
            while(!q.isEmpty()){
                int r=q.poll();
                if(visited.contains(r)){
                    continue;
                }
                visited.add(r);
                for(int nbr:rooms.get(r)){
                    if(!visited.contains(nbr)){
                        q.add(nbr);
                    }
                }
            }
        }
       // System.out.print(c);
        return c==1;
    }
}