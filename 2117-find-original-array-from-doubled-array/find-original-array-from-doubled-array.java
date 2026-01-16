class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 != 0) return new int[0];

        Arrays.sort(changed);
        Map<Integer, Integer> freq = new HashMap<>();

        for (int x : changed) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        int[] original = new int[n / 2];
        int idx = 0;

        for (int x : changed) {
            if (freq.get(x) == 0) continue;

            if (x == 0) {
                if (freq.get(x) < 2) return new int[0];
                original[idx++] = 0;
                freq.put(0, freq.get(0) - 2);
            } else {
                if (freq.getOrDefault(2 * x, 0) == 0)
                    return new int[0];

                original[idx++] = x;
                freq.put(x, freq.get(x) - 1);
                freq.put(2 * x, freq.get(2 * x) - 1);
            }
        }

        return original;
    }
}