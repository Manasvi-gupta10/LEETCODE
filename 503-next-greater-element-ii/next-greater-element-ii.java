class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        Arrays.fill(ans,-1);
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&nums[st.peek()]<nums[i]){
                ans[st.pop()]=nums[i];
            }
            st.push(i);
        }
        System.out.println(st);
        while(!st.isEmpty()){
            int in=st.pop();
            for(int i=0;i<in;i++){
                if(nums[i]>nums[in]){
                    ans[in]=nums[i];
                    break;
                }
            }
        }
        return ans;
    }
}