class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1000000007;

        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());
        }

        for (int i = 0; i < roads.length; i++) {
            map.get(roads[i][0]).put(roads[i][1], roads[i][2]);
            map.get(roads[i][1]).put(roads[i][0], roads[i][2]);
        }

        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> (int)(a.cost - b.cost));

        dist[0] = 0;
        ways[0] = 1;
        pq.add(new pair(0, 0L));

        while (!pq.isEmpty()) {
            pair r = pq.poll();

            if (r.cost > dist[r.val]) continue;

            for (int k : map.get(r.val).keySet()) {
                long newCost = r.cost + map.get(r.val).get(k);

                if (newCost < dist[k]) {
                    dist[k] = newCost;
                    ways[k] = ways[r.val];
                    pq.add(new pair(k,newCost));
                }
                
                else if (newCost == dist[k]) {
                    ways[k] = (ways[k] + ways[r.val]) % MOD;
                }
            }
        }
        return ways[n - 1];
    }
}

class pair {
    int val;
    long cost;
    public pair(int val, long cost) {
        this.val = val;
        this.cost = cost;
    }
}
