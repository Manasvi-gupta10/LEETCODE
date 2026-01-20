class Solution {
    public int maximumLength(String s) {
        int n=s.length();
        int[] len=new int[n];
        len[0]=1;
        for(int i=1;i<n;i++){
            if(s.charAt(i)==s.charAt(i-1)){
                len[i]=len[i-1]+1;
            }else{
                len[i]=1;
            }
        }
        HashMap<Character,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(s.charAt(i))){
                map.get(s.charAt(i)).add(len[i]);
            }else{
                map.put(s.charAt(i),new ArrayList<>());
                map.get(s.charAt(i)).add(len[i]);
            }
        }
        for(List<Integer> ls:map.values()){
            Collections.sort(ls,Collections.reverseOrder());
        }
        int ans=-1;
        for(List<Integer> ls:map.values()){
            if(ls.size()>=3){
                ans=Math.max(ans,ls.get(2));
            }
        }
        return ans;
    }
}