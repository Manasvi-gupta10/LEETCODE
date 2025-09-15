class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<brokenLetters.length();i++){
            set.add(brokenLetters.charAt(i));
        }
        int ans=0;
        String[] st=text.split("\\s");
        for(int i=0;i<st.length;i++){
            int j=0;
            //System.out.println(st[i]);
            while(j<st[i].length()){
                if(set.contains(st[i].charAt(j))){
                    break;
                }
                j++;
            }
            if(j==st[i].length()){
                ans++;
                
            }
        }
        return ans;
    }
}