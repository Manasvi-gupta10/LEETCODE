class Solution {
    public int maxArea(int[] height) {
        int l=0;
        int r=height.length-1;
        int marea=0;
        while(l<r){
            int length=Math.min(height[l],height[r]);
            int width=r-l;
            int area=length*width;
            marea=Math.max(marea,area);
            if(height[l]<height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return marea;
    }
}