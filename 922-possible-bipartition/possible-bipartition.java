class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes){
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=1;i<=n;i++){
            map.put(i,new ArrayList<>());
        }
        int l=dislikes.length;
        for(int i=0;i<l;i++){
            map.get(dislikes[i][0]).add(dislikes[i][1]);
            map.get(dislikes[i][1]).add(dislikes[i][0]);
        }
        Queue<pair> q=new LinkedList<>();
        HashMap<Integer,Integer> visit=new HashMap<>();
        
        for(int i=1;i<=n;i++){
            if(visit.containsKey(i)){
                continue;
            }
            q.add(new pair(i,0));
            while(!q.isEmpty()){
            pair r=q.poll();
            if(visit.containsKey(r.val)){
                if(visit.get(r.val)!=r.dis){
                    return false;
                }
                continue;
            }
            visit.put(r.val,r.dis);
            for(int nb:map.get(r.val)){
                if(!visit.containsKey(nb)){
                    q.add(new pair(nb,r.dis+1));
                }
            }
            
        }
 
        }
       return true;
        

        
    }
}
class pair{
    int val;
    int dis;
    public pair(int val,int dis){
        this.val=val;
        this.dis=dis;
    }
}