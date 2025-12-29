class Solution {
    public int subsetXORSum(int[] nums) {
        ArrayList<Integer> ls=new ArrayList<>();
        ArrayList<ArrayList<Integer>> ar=new ArrayList<>();
        subset(nums,0,ls,ar);
        //System.out.print(ar);
        long ans=0;
        for(int i=0;i<ar.size();i++){
            long xor=0;
            ArrayList<Integer> t=ar.get(i);
            for(int j=0;j<t.size();j++){
                xor^=t.get(j);

            }
            ans+=xor;

        }
        return (int)ans;
        
    }
    public void subset(int[] nums,int in,ArrayList<Integer> ls,ArrayList<ArrayList<Integer>> ar){
        ar.add(new ArrayList<>(ls));
        for(int i=in;i<nums.length;i++){
            ls.add(nums[i]);
            subset(nums,i+1,ls,ar);
            ls.remove(ls.size()-1);
        }

    }
}