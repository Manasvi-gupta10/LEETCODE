class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n=tickets.length;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            q.add(i);
        }
        int ans=0;
        while(!q.isEmpty()){
            int r=q.poll();
            tickets[r]=tickets[r]-1;
            ans++;
            if(r==k&&tickets[r]==0){
                return ans;
            }
            if(tickets[r]>0){
                q.add(r);
            }
        }
        return ans;
        
    }
}