class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> ls=new ArrayList<>();
        part(s,ans,ls);
        return ans;
    }
    public void part(String s,List<List<String>> ans,List<String> ls){
        if(s.length()==0){
            ans.add(new ArrayList<>(ls));
            return;
        }
        for(int i=1;i<=s.length();i++){
            String s1=s.substring(0,i);
            if(palin(s1)){
                ls.add(s1);
                part(s.substring(i),ans,ls);
                ls.remove(ls.size()-1);
            }
        }
    }
    public boolean palin(String s){
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}