class Solution {
    public String makeLargestSpecial(String s) {
        List<String> parts = new ArrayList<>();
        int balance = 0;
        int start = 0;

        // Step 1: split into top-level special substrings
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') balance++;
            else balance--;

            if (balance == 0) {
                String inner = s.substring(start + 1, i);
                parts.add("1" + makeLargestSpecial(inner) + "0");
                start = i + 1;
            }
        }

        // Step 2: sort in descending order
        Collections.sort(parts, Collections.reverseOrder());

        // Step 3: join all parts
        StringBuilder ans = new StringBuilder();
        for (String p : parts) {
            ans.append(p);
        }

        return ans.toString();
    }
}