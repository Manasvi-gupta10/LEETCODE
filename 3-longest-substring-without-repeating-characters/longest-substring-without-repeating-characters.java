class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int n=s.length();
        int ei=0,si=0;
        int ans=0;
        while(ei<n){
            map.put(s.charAt(ei),map.getOrDefault(s.charAt(ei),0)+1);
            while(map.get(s.charAt(ei))>1&&si<ei){
                if(map.containsKey(s.charAt(si))){
                    map.put(s.charAt(si),map.get(s.charAt(si))-1);
                    if(map.get(s.charAt(si))==0){
                        map.remove(s.charAt(si));
                    }
                }
                
                si++;
            }
            ans=Math.max(ans,ei-si+1);
            ei++;
        }
        return ans;
        
    }
}