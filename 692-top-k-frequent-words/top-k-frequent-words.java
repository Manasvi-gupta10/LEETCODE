
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans=new ArrayList<>();
        int n=words.length;
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
            if(a.fr!=b.fr){
                return b.fr-a.fr;
            }else{
                return a.w.compareTo(b.w); 
            }
        });
        for(String key:map.keySet()){
            pq.add(new pair(key,map.get(key)));
        }
        for(int i=0;i<k;i++){
            ans.add(pq.poll().w);
        }
        
        return ans;
    }
    class pair{
        String w;
        int fr;
        public pair(String w,int fr){
            this.w=w;
            this.fr=fr;
        }
    }
}