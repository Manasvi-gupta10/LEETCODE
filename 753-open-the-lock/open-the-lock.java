class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> set=new HashSet<>();
        for(String s:deadends){
            set.add(s);
        }
        if(set.contains("0000")){
            return -1;
        }
        set.add("0000");
        Queue<pair> q=new LinkedList<>();
        
        q.add(new pair("0000",0));
        while(!q.isEmpty()){
            pair r=q.poll();
            if(r.l.equals(target)){
                return r.turns;
            }
            char[] st=r.l.toCharArray();
            for(int i=0;i<st.length;i++){
                char ch=st[i];
                for(int in=0;in<2;in++){
                    if(in==0){
                        if(ch=='0'){
                            st[i]='9';
                        }else{
                            st[i]=(char)(st[i]-1);
                        }
                        
                    }else{
                        if(ch=='9'){
                            st[i]='0';
                        }else{
                            st[i]=(char)(st[i]+1);
                        }
                    }
                    String change=new String(st);
                    if(!set.contains(change)){
                        set.add(change);
                        q.add(new pair(change,r.turns+1));
                    }
                    
                    
                     st[i]=ch;
                }
               
            }
        }

        return -1;
    }
}
class pair{
    String l;
    int turns;
    public pair(String l,int turns){
        this.l=l;
        this.turns=turns;
    }
}