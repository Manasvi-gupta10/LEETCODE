class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n=security.length;
        List<Integer> ans=new ArrayList<>();
        int[] pre=new int[n];
        int[] post=new int[n];
        pre[0]=1;
        post[n-1]=1;
        for(int i=1;i<n;i++){
            if(security[i]<=security[i-1]){
                pre[i]=pre[i-1]+1;

            }else{
                pre[i]=1;
            }
        }
        for(int i=n-2;i>=0;i--){
            if(security[i]<=security[i+1]){
                post[i]=post[i+1]+1;
            }else{
                post[i]=1;
            }
        }
        for(int i=time;i<n-time;i++){
            if(pre[i]>time&&post[i]>time){
                ans.add(i);
            }
        }
        return ans;
    }
}