class Solution {
    public int countArrangement(int n) {
        return permut(n,new ArrayList<Integer>());
    }
    public int permut(int n,ArrayList<Integer> ls){
        if(ls.size()==n){
            return 1;
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
    
}