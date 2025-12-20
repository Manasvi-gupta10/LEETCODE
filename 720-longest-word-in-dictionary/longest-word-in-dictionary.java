class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        int n=words.length;
        HashSet<String> set=new HashSet<>();
        String ans="";
        set.add("");
        for(int i=0;i<n;i++){
            String w=words[i];
            String pref=w.substring(0,w.length()-1);
            if(set.contains(pref)){
                set.add(w);
                if(w.length()>ans.length()||(w.length()==ans.length()&&w.compareTo(ans)<0)){
                    ans=w;
                }
            }
        }
        return ans;
        
    }
}