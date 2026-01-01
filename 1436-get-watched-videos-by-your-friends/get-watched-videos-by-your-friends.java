class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        
        Queue<Integer> q=new LinkedList<>();
        q.add(id);
        int lv=0;
        boolean[] visit=new boolean[friends.length];
        visit[id]=true;
        while(!q.isEmpty()&&lv<level){
            int sz=q.size();
            for(int i=0;i<sz;i++){
                int r=q.poll();
                for(int nb:friends[r]){
                    if(!visit[nb]){
                        q.add(nb);
                        visit[nb]=true;
                    }
                }
            }
            
            lv++;


        }
        HashMap<String,Integer> fr=new HashMap<>();
        while(!q.isEmpty()){
            int r=q.poll();
            for(String nb:watchedVideos.get(r)){
                fr.put(nb,fr.getOrDefault(nb,0)+1);
            }
        }
        List<String> ans=new ArrayList<>(fr.keySet());
        ans.sort((a, b) -> {
            if (!fr.get(a).equals(fr.get(b))) {
                return fr.get(a) - fr.get(b);
            }
            return a.compareTo(b);
        });
        return ans;

    }
}