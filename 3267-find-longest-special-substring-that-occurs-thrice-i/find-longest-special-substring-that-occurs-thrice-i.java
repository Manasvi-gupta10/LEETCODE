class Solution {
    public int maximumLength(String s) {
        int n=s.length();
        HashMap<String,Integer> map=new HashMap<>();
        for(int len=1;len<=n;len++){
            for(int j=len;j<=n;j++){
                int i=j-len;
                String sub=s.substring(i,j);
                if(special(sub)){
                   map.put(sub,map.getOrDefault(sub,0)+1);
                    
                }
            }
        }
        int ans=-1;
        for(String k:map.keySet()){
            if(map.get(k)>=3){
                ans=Math.max(ans,k.length());
            }
        }

        return ans;
    }
    public boolean special(String s){
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)!=s.charAt(i-1)){
                return false;
            }
        }
        return true;
    }
}