class Solution {
    public long maxArrayValue(int[] nums) {
        int n=nums.length;
        
        ArrayList<Long> ls=new ArrayList<>();
        for(int j=0;j<n;j++){
            ls.add((long)nums[j]);
        }
        while(true){
            int i=ls.size()-1;
            boolean work=false;
            while(i>0){
                if(ls.get(i-1)<=ls.get(i)){
                    long newv=ls.get(i)+ls.get(i-1);
                    ls.remove(i);
                    ls.remove(i-1);
                    ls.add(i-1,newv);
                    work=true;
                    break;

                }
                i--;
            }
            if(!work){
                break;
            }
        }
        Collections.sort(ls);
        return ls.get(ls.size()-1);
    }
}