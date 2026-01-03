class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        HashSet<String> set=new HashSet<>(wordList);
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(beginWord,1));
        if(set.contains(beginWord)){
            set.remove(beginWord);
        }
        while(!q.isEmpty()){
            pair r=q.poll();
            if(r.w.equals(endWord)){
                return r.steps;
            }
            char[] st=r.w.toCharArray();
            for(int i=0;i<st.length;i++){
                char ch=st[i];
                for(char j='a';j<='z';j++){
                    if(ch==j){
                        continue;
                    }
                    st[i]=j;
                    String change=new String(st);
                    if(set.contains(change)){
                        q.add(new pair(change,r.steps+1));
                        set.remove(change);
                    }
                    st[i]=ch;
                }
            }

        }


        return 0;
        
    }
}
class pair{
    String w;
    int steps;
    public pair(String w,int steps){
        this.w=w;
        this.steps=steps;
    }
}