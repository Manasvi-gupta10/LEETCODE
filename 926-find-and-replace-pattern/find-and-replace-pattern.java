class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int n=words.length;
        
        List<String> ls=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(ispos(words[i],pattern)){
                ls.add(words[i]);
            }
        }
        return ls;
        
    }
    public boolean ispos(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Integer,Integer> map1=new HashMap<>();
        HashMap<Integer,Integer> map2=new HashMap<>();
        ArrayList<Character> set=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                map1.put(i,findi(set,s.charAt(i)));
            }
            else{
                map1.put(i,i);
                set.add(s.charAt(i));
            }
        }
        set.clear();
        for(int i=0;i<t.length();i++){
            if(set.contains(t.charAt(i))){
                map2.put(i,findi(set,t.charAt(i)));
            }
            else{
                map2.put(i,i);
                set.add(t.charAt(i));
            }
        }
        
        for(int i:map1.keySet()){
            if(map1.get(i)!=map2.get(i)){
                return false;
            }
        }
        return true;
    }
    public int findi(ArrayList<Character> set,char chr){
        for(int i=0;i<set.size();i++){
            if(set.get(i)==chr){
                return i;
            }
        }
        return -1;
    }
}