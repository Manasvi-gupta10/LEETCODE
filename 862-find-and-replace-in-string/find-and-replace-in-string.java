import java.util.*;

class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {

        int n = s.length();
        StringBuilder sb = new StringBuilder();

        // index -> list of replacement indices
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < indices.length; i++) {
            map.computeIfAbsent(indices[i], k -> new ArrayList<>()).add(i);
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
                        break; // apply only one replacement
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
