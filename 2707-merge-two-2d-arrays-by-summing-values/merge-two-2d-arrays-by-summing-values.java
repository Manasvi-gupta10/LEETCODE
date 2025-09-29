class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int[][] an=new int[n1+n2][2];
        int k=0;
        int i=0,j=0;
        while(i<n1&&j<n2){
            if(nums1[i][0]==nums2[j][0]){
                an[k][0]=nums1[i][0];
                an[k][1]=nums1[i][1]+nums2[j][1];
                i++;
                j++;
                k++;
            }else if(nums1[i][0]<nums2[j][0]){
                 an[k][0]=nums1[i][0];
                an[k][1]=nums1[i][1];
                i++;
                k++;
            }else{
                an[k][0]=nums2[j][0];
                an[k][1]=nums2[j][1];
                j++;
                k++;
            }
        }
        while(i<n1){
            an[k][0]=nums1[i][0];
            an[k][1]=nums1[i][1];
            i++;
            k++;
        }
        while(j<n2){
            an[k][0]=nums2[j][0];
            an[k][1]=nums2[j][1];
            j++;
            k++;
        }
        int[][] ans=new int[k][2];
        for(int in=0;in<k;in++){
            ans[in][0]=an[in][0];
            ans[in][1]=an[in][1];
        }
        return ans;
    }
}