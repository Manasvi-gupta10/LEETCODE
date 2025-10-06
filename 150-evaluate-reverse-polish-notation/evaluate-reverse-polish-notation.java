class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        int n=tokens.length;
        for(int i=0;i<n;i++){
            String s=tokens[i];
            if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
                int a=st.pop();
                int b=st.pop();
                if(s.equals("+")){
                    st.push(b+a);
                }else if(s.equals("-")){
                    st.push(b-a);
                }else if(s.equals("*")){
                    st.push(b*a);
                }else{
                    st.push(b/a);
                }
            }else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.peek();
    }
}