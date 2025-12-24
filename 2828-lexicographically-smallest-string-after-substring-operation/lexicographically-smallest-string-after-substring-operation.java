class Solution {
    public String smallestString(String s) {
        int n = s.length();
        int si = 0;
        int e = 0;

        while (si < n && s.charAt(si) == 'a') {
            si++;
        }

        
        if (si == n) {
            StringBuilder sb = new StringBuilder(s);
            sb.setCharAt(n - 1, 'z');
            return sb.toString();
        }
        e = si;
        while (e < n && s.charAt(e) != 'a') {
            e++;
        }

        StringBuilder sb = new StringBuilder();

        sb.append(s.substring(0, si));

        for (int i = si; i < e; i++) {
            char nc = (char) ('a' + (s.charAt(i) - 'a' + 25) % 26);
            sb.append(nc);
        }

        sb.append(s.substring(e, n));
        return sb.toString();
    }
}
