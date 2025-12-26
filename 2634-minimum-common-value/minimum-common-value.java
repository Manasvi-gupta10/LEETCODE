class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        HashSet<Integer> set=new HashSet<>();
        int l=nums2.length;
        for(int i=0;i<l;i++){
            set.add(nums2[i]);
        }
        int n=nums1.length;
        for(int i=0;i<n;i++){
            if(set.contains(nums1[i])){
                return nums1[i];
            }
        }
        return -1;
        
    }
}