class Solution {
    public String resultingString(String s) {
        int n=s.length();
        if(n<2){
            return s;
        }
        StringBuilder sb=new StringBuilder();
        Stack<Character> st=new Stack<>();
     
        for(int i=0;i<s.length();i++){
                char c1=s.charAt(i);
                if(!st.isEmpty()){
                    char c2=st.peek();
                    int dif=Math.abs(c1-c2);
                    if(dif==1||(c1=='a'&&c2=='z')||(c1=='z'&&c2=='a')){
                        st.pop();
                    
                     }else{
                        st.push(c1);
                     }
                }else{
                    st.push(c1);
                }
            }
        for(char c:st){
            sb.append(c);
        }
            
        
        return sb.toString();
    }
}