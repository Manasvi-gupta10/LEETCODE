class Solution {
    public int findCircleNum(int[][] isConnected) {
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        int n=isConnected.length;
        for(int i=1;i<=n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }
                if(isConnected[i][j]==1){
                    map.get(i+1).add(j+1);
                }
            }
        }
        int prov=0;
        HashSet<Integer> visited=new HashSet<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i:map.keySet()){
            if(visited.contains(i)){
                continue;
            }
            prov++;
            q.add(i);
            while(!q.isEmpty()){
                int r=q.poll();
                if(visited.contains(r)){
                    continue;
                }
                visited.add(r);
                for(int nbr:map.get(r)){
                    
                    if(!visited.contains(nbr)){
                        q.add(nbr);
                    }
                }
            }
        }
        return prov;
    }
}