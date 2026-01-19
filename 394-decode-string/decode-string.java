class Solution {
    public String decodeString(String s) {
        int n=s.length();
        Stack<String> st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                if(!st.isEmpty()&&st.peek().matches("\\d+")){
                    String s1=st.pop()+ch;
                    st.push(s1);
                }else{
                    st.push(ch+"");
                }
            }
            else if(ch=='['){
                st.push(ch+"");
            }
            else if(ch==']'){
                StringBuilder temp=new StringBuilder();
                while(!st.isEmpty()&&!st.peek().equals("[")){
                    temp.insert(0,st.pop());
                }
                st.pop();
                int num=Integer.parseInt(st.pop());
                StringBuilder t=new StringBuilder();
                
                while(num-->0){
                    t.append(temp);
                }
                st.push(t.toString());

            }else{
                st.push(ch+"");
            }

        }
        for(String e:st){
            sb.append(e);
        }
        return sb.toString();
        
    }
}