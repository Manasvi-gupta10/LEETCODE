class Solution {
    public long maxStrength(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        boolean v=false;
        ArrayList<Integer> ls=new ArrayList<>();
        long score=1;
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                score*=nums[i];
                v=true;
            }else if(nums[i]<0){
                ls.add(nums[i]);
            }
        }
        Collections.sort(ls);
        if(ls.size()%2==0){
            for(int e:ls){
                score*=e;
                v=true;
            }
        }else{
            for(int i=0;i<ls.size()-1;i++){
                score*=ls.get(i);
                v=true;
            }
        }
        if(!v){
            return 0;
        }
        return score;
        
    }
}
