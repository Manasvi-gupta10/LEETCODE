class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ls=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
        }
        permut(sb,0,ls);
        return ls;
    }
    public void permut(StringBuilder s,int i,List<String> ls){
        if(i==s.length()){
            ls.add(s.toString());
            return;
        }
        if(s.charAt(i)>=65&&s.charAt(i)<=90){
            int ch=s.charAt(i);
            permut(s,i+1,ls);
            s.deleteCharAt(i);
            s.insert(i,(char)(ch+32));
            permut(s,i+1,ls);
        }
        else if(s.charAt(i)>=97&&s.charAt(i)<=122){
            int ch=s.charAt(i);
            permut(s,i+1,ls);
            s.deleteCharAt(i);
            s.insert(i,(char)(ch-32));
            permut(s,i+1,ls);

        }else{
            permut(s,i+1,ls);
        }
    }
}