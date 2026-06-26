class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            boolean destroy=false;
            while(!st.isEmpty()&&st.peek()>0&&asteroids[i]<0){
                int absi=Math.abs(asteroids[i]);
                //int p=st.pop();
                int absp=st.peek();
                if(absi<absp){
                    //st.push(p);
                    destroy=true;
                    break;
                }else if(absi==absp){
                    st.pop();
                    destroy=true;
                    break;
                }else{
                    st.pop();
                }
            }
            if(!destroy){
                st.push(asteroids[i]);
            }
        }
        //System.out.println(st);
        int[] ans=new int[st.size()];
        //int in=;
        for(int i=st.size()-1;i>=0;i--){
            ans[i]=st.pop();
        }
        return ans;
    }
}