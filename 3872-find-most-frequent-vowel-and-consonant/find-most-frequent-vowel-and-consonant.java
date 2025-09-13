class Solution {
    public int maxFreqSum(String s) {
        int n=s.length();
        HashMap<Character,Integer> vow=new HashMap<>();
        HashMap<Character,Integer> con=new HashMap<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                vow.put(ch,vow.getOrDefault(ch,0)+1);
            }
            else{
                con.put(ch,con.getOrDefault(ch,0)+1);
            }
        }
        int v=0,c=0;
        for(char ch:vow.keySet()){
            if(vow.get(ch)>v){
                v=vow.get(ch);
            }
        }
        for(char ch:con.keySet()){
            if(con.get(ch)>c){
                c=con.get(ch);
            }
        }
        return v+c;

    }
}