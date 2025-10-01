class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        String ans="";
        if(n<t.length()){
            return ans;
        }
        int mn=Integer.MAX_VALUE;
        int e=0,si=0;
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();
        for(int i=0;i<t.length();i++){
            map1.put(t.charAt(i),map1.getOrDefault(t.charAt(i),0)+1);
        }
        while(e<n){
            map2.put(s.charAt(e),map2.getOrDefault(s.charAt(e),0)+1);
            while(inmap(map1,map2)&&si<=e){
                map2.put(s.charAt(si),map2.get(s.charAt(si))-1);
                if(map2.get(s.charAt(si))==0){
                    map2.remove(s.charAt(si));
                }
                mn=Math.min(mn,e-si+1);
                if(mn==e-si+1){
                    ans=s.substring(si,e+1);
                }
                si++;
            }
            e++;
        }
        return ans;
    }
    public boolean inmap(HashMap<Character,Integer> map1,HashMap<Character,Integer> map2){
        for(char c:map1.keySet()){
            if(map2.getOrDefault(c,0)<map1.get(c)){
                return false;
            }
        }
        return true;
    }
}