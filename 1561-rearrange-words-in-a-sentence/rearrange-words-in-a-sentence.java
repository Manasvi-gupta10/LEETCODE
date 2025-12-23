class Solution {
    public String arrangeWords(String text) {
        String ar[] = text.split(" ");
        Arrays.sort(ar , (a,b) -> a.length()-b.length());
        StringBuilder ans = new StringBuilder();
        ans.append(capital(ar[0]));
        for (int i = 1; i < ar.length; i++) {
            ans.append(" "+ar[i].toLowerCase());
        }
        return ans.toString();
    }
    public String capital(String s) {
        if (s.length() == 0){
            return s;
        }
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
}