import java.util.*;

class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {

        int n = s.length();
        StringBuilder sb = new StringBuilder();

        
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < indices.length; i++) {
            if(!map.containsKey(indices[i])){
                map.put(indices[i],new ArrayList<>());
            }
            map.get(indices[i]).add(i);
            
        }

        int i = 0;
        while (i < n) {
            boolean replaced = false;

            if (map.containsKey(i)) {
                for (int idx : map.get(i)) {
                    String src = sources[idx];
                    String tgt = targets[idx];

                    if (i + src.length() <= n &&
                        s.substring(i, i + src.length()).equals(src)) {

                        sb.append(tgt);
                        i += src.length();
                        replaced = true;
                        break; 
                    }
                }
            }

            if (!replaced) {
                sb.append(s.charAt(i));
                i++;
            }
        }

        return sb.toString();
    }
}
