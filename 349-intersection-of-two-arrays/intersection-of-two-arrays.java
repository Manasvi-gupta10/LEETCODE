class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
       HashSet<Integer> set=new HashSet<>();
         for(int i=0;i<n1;i++){
            set.add(nums1[i]);
         }
         ArrayList<Integer> ls=new ArrayList<>();
         for(int i=0;i<n2;i++){
            if(set.contains(nums2[i])){
                ls.add(nums2[i]);
                set.remove(nums2[i]);
            }
         }
         int[] ans=new int[ls.size()];
         int i=0;
         while(i<ls.size()){
            ans[i]=ls.get(i);
            i++;
         }
         return ans;
    }
}