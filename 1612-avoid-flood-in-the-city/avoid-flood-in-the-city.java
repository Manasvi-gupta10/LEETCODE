class Solution {
    public int[] avoidFlood(int[] rains) {
        int n=rains.length;
        int[] ans=new int[n];
        Arrays.fill(ans,1);
        HashMap<Integer,Integer> map=new HashMap<>();
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=0;i<n;i++){
            if(rains[i]>0){
                ans[i]=-1;
                int lake=rains[i];
                if(map.containsKey(lake)){
                    Integer d=set.higher(map.get(lake));
                    if(d==null){
                        return new int[0];
                    }
                    ans[d]=lake;
                    set.remove(d);
                }
                map.put(lake,i);
            }else{
                set.add(i);
            }
        }
        return ans;
    }
}