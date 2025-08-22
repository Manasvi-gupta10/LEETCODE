
import java.util.*;
class Solution {
    public String frequencySort(String s) {
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->b.fr-a.fr);
        for(Character k:map.keySet()){
            pq.add(new pair(k,map.get(k)));
        }
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            pair p=pq.poll();
            for(int i=0;i<p.fr;i++){
                sb.append(p.ch);
            }
        }
        return sb.toString();
    }
    class pair{
        char ch;
        int fr;
        public pair(char ch,int fr){
            this.ch=ch;
            this.fr=fr;

        }
    }
}