class Solution {
    public String decodeString(String s) {
        Stack<Integer> st=new Stack<>();
        Stack<String> op=new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                int v=ch-'0';
                if(!st.isEmpty()&&i>0&&Character.isDigit(s.charAt(i-1))){
                    v+=st.pop()*10;
                }
                st.push(v);
            }
            else if(ch=='['){
                op.push("[");
            }
            else if(ch==']'){
                StringBuilder sb=new StringBuilder();
                while(!op.isEmpty()&&!op.peek().equals("[")){
                    sb.insert(0,op.pop());
                }
                op.pop();
                
                int t=st.pop();
                 StringBuilder b=new StringBuilder();
                 for(int j=0;j<t;j++){
                    b.append(sb);
                 }
                 op.push(b.toString());
            }else{
                op.push(ch+"");
            }
        }
        System.out.print(op);
        StringBuilder ans=new StringBuilder();
        while(!op.isEmpty()){
            
            ans.insert(0,op.pop());
        }
        return ans.toString();
    }
    
}