class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int n=s.length();
        int e=0,si=0;
        int ans=0;
        while(e<n){
            map.put(s.charAt(e),map.getOrDefault(s.charAt(e),0)+1);
            while(si<=e&&map.get(s.charAt(e))>1){
                map.put(s.charAt(si),map.get(s.charAt(si))-1);
                if(map.get(s.charAt(si))==0){
                    map.remove(s.charAt(si));
                }
                si++;
            }
            ans=Math.max(ans,e-si+1);
            e++;
        }
        return ans;
    }
}