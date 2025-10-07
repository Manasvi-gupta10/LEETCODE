class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length;
        
        int[] starts = new int[n];
        int[] ends = new int[n];
        
        for (int i = 0; i < n; i++) {
            starts[i] = flowers[i][0];
            ends[i] = flowers[i][1];
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int[] ans = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            int time = people[i];
            
            // count of flowers that have started blooming
            int started = upperBound(starts, time);
            
            // count of flowers that have already ended before this time
            int ended = lowerBound(ends, time);
            
            ans[i] = started - ended;
        }
        
        return ans;
    }
       private int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    // returns index of first element greater or equal to target
    private int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}