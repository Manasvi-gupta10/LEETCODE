class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums2.length;
        int[] ans=new int[n];
        Stack<Integer> st=new Stack<Integer>();
        Arrays.fill(ans,-1);
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&nums2[i]>nums2[st.peek()]){
                ans[st.pop()]=nums2[i];
            }
            st.push(i);
        }
        int[] an=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<n;j++){
                if(nums1[i]==nums2[j]){
                    an[i]=ans[j];
                    break;
                }
            }
        }
        return an;
    }
}