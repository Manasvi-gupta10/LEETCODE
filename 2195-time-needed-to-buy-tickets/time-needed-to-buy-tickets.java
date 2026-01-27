class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n=tickets.length;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            q.add(new int[]{tickets[i],i});
        }
        int ans=0;
        while(!q.isEmpty()){
            int[] ar=q.poll();
            ar[0]=ar[0]-1;
            ans++;
            if(ar[1]==k&&ar[0]==0){
                return ans;
            }
            if(ar[0]>0){
                q.add(ar);
            }
        }
        return ans;
        
    }
}