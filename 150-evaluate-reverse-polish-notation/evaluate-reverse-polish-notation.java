class Solution {
    public int evalRPN(String[] tokens) {
        int n=tokens.length;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            String t=tokens[i];
            if(t.equals("+")||t.equals("-")||t.equals("*")||t.equals("/")){
                int a=st.pop();
                int b=st.pop();
                if(t.equals("+")){
                    st.push(b+a);
                }else if(t.equals("-")){
                    st.push(b-a);
                }else if(t.equals("/")){
                    st.push(b/a);
                }else if(t.equals("*")){
                    st.push(b*a);
                }
            }else{
                st.push(Integer.parseInt(t));
            }
        }
        return st.peek();
    }
}