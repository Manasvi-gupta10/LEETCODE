class Solution {
    public int countArrangement(int n) {
        return permut(n,new ArrayList<Integer>());
    }
    public int permut(int n,ArrayList<Integer> ls){
        if(ls.size()==n){
            if(beautiful(ls)){
                return 1;
            }else{
                return 0;
            }
        }
        int ans=0;
        for(int i=1;i<=n;i++){
            if(!ls.contains(i)&&((ls.size()+1)%i==0||i%(ls.size()+1)==0)){
                ls.add(i);
                ans+=permut(n,ls);
                ls.remove(ls.size()-1);
            }
        }
        return ans;
    }
    public boolean beautiful(ArrayList<Integer> ls){
        for(int i=0;i<ls.size();i++){
            if((i+1)%ls.get(i)!=0&&ls.get(i)%(i+1)!=0){
                return false;
            }
        }
        return true;
    }
}