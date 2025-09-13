class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        int n=messages.length;
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            String s=messages[i];
            String[] sp=s.split("\\s");
            map.put(senders[i],map.getOrDefault(senders[i],0)+sp.length);
        }
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
            if(a.n!=b.n){
                return b.n-a.n;
            }else{
                return b.nm.compareTo(a.nm);
            }
        });
        for(String s:map.keySet()){
            pq.add(new pair(s,map.get(s)));
        }
        return pq.peek().nm;

    }
    public class pair{
        String nm;
        int n;
        public pair(String nm,int n){
            this.nm=nm;
            this.n=n;
        }
    }
}