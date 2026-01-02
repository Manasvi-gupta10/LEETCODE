class Solution {
    public int edgeScore(int[] edges) {
        int n=edges.length;
        TreeMap<Integer,Long> map=new TreeMap<>();
        for(int i=0;i<n;i++){
            map.put(edges[i],map.getOrDefault(edges[i],0L)+i);
        }
        long sc=0;
        int ans=0;
        for(int k:map.keySet()){
            if(sc<map.get(k)){
                sc=map.get(k);
                ans=k;
            }
        }
        return ans;
        
    }
}