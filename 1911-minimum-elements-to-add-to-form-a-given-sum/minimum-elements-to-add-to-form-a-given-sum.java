class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0 ;
        for(int n : nums){
            sum+=n;
        }
        long required = Math.abs((long)goal - sum);

        return (int)((required+limit-1)/limit);
    }
}