class Solution {
    public String simplifyPath(String path) {
        String[] part=path.split("/");
        Stack<String> st=new Stack<>();
        for(int i=0;i<part.length;i++){
            String s=part[i];
            if(s.equals("")||s.equals(".")){
                continue;
            }
            else if(s.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }else{
                st.push(s);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(String i:st){
            sb.append("/").append(i);
        }
        if(sb.length()==0){
            return "/";
        }
        return sb.toString();
    }
}