class Solution {
    public int calculate(String s) {
        int n=s.length();
        Stack<Character> op=new Stack<>();
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;){
            char ch=s.charAt(i);
            if(ch==' '){
                i++;
                continue;
            }
            else if(Character.isDigit(ch)){
                int num=0;
                while(i<n&&Character.isDigit(s.charAt(i))){
                    num=num*10+(s.charAt(i)-'0');
                    i++;
                }
                st.push(num);
            }else{
                while(!op.isEmpty()&&prec(op.peek())>=prec(ch)){
                    int a=st.pop();
                    int b=st.pop();
                    char c=op.pop();
                    st.push(apply(b,a,c));
                }
                op.push(ch);
                i++;
            }
        }
        while (!op.isEmpty()) {
    int a = st.pop();
    int b = st.pop();
    char c = op.pop();
    st.push(apply(b, a, c));
}

        return st.peek();
    }
    public int prec(char ch){
        if(ch=='/'||ch=='*'){
            return 2;
        }else if(ch=='+'||ch=='-'){
            return 1;
        }
        return 0;
    }
    private int apply(int a, int b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;  // truncates toward zero automatically in Java
        }
        return 0;
    }
}