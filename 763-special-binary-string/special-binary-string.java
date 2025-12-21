class Solution {
    public String makeLargestSpecial(String s) {
        List<String> parts = new ArrayList<>();
        int balance = 0;
        int start = 0;

       
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') balance++;
            else balance--;

            if (balance == 0) {
                String inner = s.substring(start + 1, i);
                parts.add("1" + makeLargestSpecial(inner) + "0");
                start = i + 1;
            }
        }

        
        Collections.sort(parts, Collections.reverseOrder());

        
        StringBuilder ans = new StringBuilder();
        for (String p : parts) {
            ans.append(p);
        }

        return ans.toString();
    }
}