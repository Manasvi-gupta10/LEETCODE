class Solution {
    public String minRemoveToMakeValid(String s) {
        int n=s.length();
        List<Character> ls=new ArrayList<>();
        int cnt=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                ls.add(ch);
                cnt++;
            }else if(ch==')'&&cnt>0){
                cnt--;
                ls.add(ch);
            }else if(ch!=')'){
                ls.add(ch);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=ls.size()-1;i>=0;i--){
            if(ls.get(i)=='('&&cnt>0){
                cnt--;
            }else{
                sb.append(ls.get(i));
            }
        }
        return sb.reverse().toString();
    }
}