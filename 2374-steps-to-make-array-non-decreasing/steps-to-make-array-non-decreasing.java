class Solution {
    public int totalSteps(int[] nums) {
        int n=nums.length;
        int ans=0;
        Stack<int[]> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            int steps=0;
            while(!st.isEmpty()&&nums[i]>st.peek()[0]){
                steps=Math.max(steps+1,st.pop()[1]);
            }
            ans=Math.max(ans,steps);
            st.push(new int[]{nums[i],steps});
        }
        return ans;
    }
}