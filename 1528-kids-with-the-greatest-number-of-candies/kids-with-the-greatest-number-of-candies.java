
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans=new ArrayList<>();
        for(int i=0;i<candies.length;i++){
            int tot=candies[i]+extraCandies;
            ans.add(check(candies,tot));
        }
        return ans;
    }
    public boolean check(int[] nums,int n){
        for(int i=0;i<nums.length;i++){
            if(nums[i]>n){
                return false;
            }
        }
        return true;
    }
}