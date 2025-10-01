
import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        ArrayList<Character> ac=new ArrayList<>();
        int si=0,ep=0,ans=0;
        for(;ep<s.length();){
            if(!ac.contains(s.charAt(ep))){
                ac.add(s.charAt(ep));
                ans=Math.max(ac.size(),ans);
                ep++;
            }
            else{
                ac.clear();
                ep=si;
                si++;
            }
        }
        return ans;
    }  
}
