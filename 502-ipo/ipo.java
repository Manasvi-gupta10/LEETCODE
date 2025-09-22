import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] ar = new int[n][2];

        
        for (int i = 0; i < n; i++) {
            ar[i][0] = capital[i];
            ar[i][1] = profits[i];
        }
        Arrays.sort(ar, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;  
        for (int i = 0; i < k; i++) {
            while (idx < n && ar[idx][0] <= w) {
                pq.add(ar[idx][1]);
                idx++;
            }
            if (pq.isEmpty()){
                break;
            }
            w += pq.poll();
        }
        return w;
    }
}
