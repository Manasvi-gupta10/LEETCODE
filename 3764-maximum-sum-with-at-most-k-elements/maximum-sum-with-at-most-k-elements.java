
class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            Arrays.sort(grid[i]);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            
           for (int j = m - 1; j >= m - limits[i] && j >= 0; j--) {
    pq.add(grid[i][j]);
}

            
        }
        if(pq.isEmpty()){
            return 0;
        }
        long ans=0;
        for(int i=0;i<k;i++){
            ans+=pq.poll();
        }
        return ans;
    }
}