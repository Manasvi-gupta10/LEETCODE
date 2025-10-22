class Solution {
    public String removeDuplicates(String s, int k) {
        int n=s.length();
        Stack<Integer> occ=new Stack<>();
        Stack<Character> chr=new Stack<>();
        occ.add(1);
        chr.add(s.charAt(0));
        for(int i=1;i<n;i++){
            char ch=s.charAt(i);
            if(!chr.isEmpty()&&chr.peek()==ch){
                occ.push(occ.pop()+1);
            }
            else{
                occ.push(1);
                chr.push(ch);
            }
            if(occ.peek()==k){
                occ.pop();
                chr.pop();
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!occ.isEmpty()){
            char ch=chr.pop();
            int oc=occ.pop();
            while(oc-->0){
                sb.append(ch);
            }
        }
        return sb.reverse().toString();
    }
}