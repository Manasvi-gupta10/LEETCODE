import java.util.*;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int[] ans=new int[n+m];
        int in=0;
        for(int i=0;i<n;i++){
            ans[in++]=nums1[i];
        }
        for(int i=0;i<m;i++){
            ans[in++]=nums2[i];
        }
        double an=0;
        Arrays.sort(ans);
        int nu=ans.length;
        if(nu%2!=0){
            an=ans[nu/2];
        }else{
            an=(double)(ans[nu/2]+ans[nu/2-1])/2;
        }
        return an;
    }
}