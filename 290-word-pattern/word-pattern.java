class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] word=s.split(" ");
        int n=pattern.length();
        
        if(word.length!=n){
            return false;
        }
        
        HashMap<Character,String> map1=new HashMap<>();
        HashMap<String,Character> map2=new HashMap<>();
        for(int i=0;i<n;i++){
            char ch=pattern.charAt(i);
            String v=word[i];
            if(map1.containsKey(ch)&&!map1.get(ch).equals(v)){
                return false;

            }else if(!map1.containsKey(ch)){
                map1.put(ch,v);
            }
            if(map2.containsKey(v)&&map2.get(v)!=ch){
                return false;

            }else if(!map2.containsKey(v)){
                map2.put(v,ch);
            }

        }

        return map1.size()==map2.size();
    }
}