import java.util.*;

class Solution {
    public int primeSubarray(int[] nums, int k) {
        int n = nums.length;
        int si = 0, ans = 0;

        TreeMap<Integer, Integer> primes = new TreeMap<>();
        ArrayList<Integer> primeIdx = new ArrayList<>();

        for (int ei = 0; ei < n; ei++) {

            if (prime(nums[ei])) {
                primes.put(nums[ei], primes.getOrDefault(nums[ei], 0) + 1);
                primeIdx.add(ei);
            }

            while (primes.size() >= 2 &&
                   primes.lastKey() - primes.firstKey() > k) {

                if (prime(nums[si])) {
                    int v = nums[si];
                    primes.put(v, primes.get(v) - 1);
                    if (primes.get(v) == 0) primes.remove(v);
                }
                si++;
            }

            int m = primeIdx.size();
            if (m >= 2) {
                int secondLastPrimeIdx = primeIdx.get(m - 2);
                if (secondLastPrimeIdx >= si) {
                    ans += (secondLastPrimeIdx - si + 1);
                }
            }
        }
        return ans;
    }

    public boolean prime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
