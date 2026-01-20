class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1=new Stack<>();
         Stack<Character> st2=new Stack<>();
        int sn=s.length();
        int tn=t.length();
        for(int i=0;i<sn;i++){
            char ch=s.charAt(i);
            if(ch=='#'){
               if(!st1.isEmpty()){
                 st1.pop();
               }

            }else{
                st1.push(ch);
            }
        }
        for(int i=0;i<tn;i++){
            char ch=t.charAt(i);
            if(ch=='#'){
               if(!st2.isEmpty()){
                 st2.pop();
               }

            }else{
                st2.push(ch);
            }
        }
        if(st1.isEmpty()&&st2.isEmpty()){
            return true;
        }
        if(st1.size()!=st2.size()){
            return false;
        }
        while(!st1.isEmpty()&&!st2.isEmpty()){
            if(st1.pop()!=st2.pop()){
                return false;
            }
        }
        return true;


    }
}