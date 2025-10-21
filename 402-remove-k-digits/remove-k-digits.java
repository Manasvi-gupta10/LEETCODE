class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st=new Stack<>();
        int n=num.length();
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&k>0&&num.charAt(i)<st.peek()){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));

        }
        while(k>0&&!st.isEmpty()){
            st.pop();
            k--;
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        int i=0;
        while(i<sb.length()&&sb.charAt(i)=='0'){
            i++;
        }
        String ans=sb.toString().substring(i);
        if(ans.equals("")){
            return "0";
        }
        return ans;
        
    }
}