import java.util.*;
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        int[] ar=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]>0&&nums[i]<=n){
                ar[nums[i]-1]=1;
            }
        }
        for(int i=0;i<n;i++){
            if(ar[i]==0){
                return i+1;
            }
        }
        return n+1;
    }
}