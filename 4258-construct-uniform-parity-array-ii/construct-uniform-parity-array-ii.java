class Solution {
    public boolean uniformArray(int[] nums1) {
        int n=nums1.length;
        if(oddeven(nums1)){
            return true;
        }
        int minodd=Integer.MAX_VALUE;
        for(int num:nums1){
            if(num%2!=0){
                minodd=Math.min(minodd,num);
            }
        }
        System.out.println(minodd);
        for(int num:nums1){
            if(num%2==0&&minodd>num){
                return false;
                
            }
        }
        return true;
    }
    public boolean oddeven(int[] ar){
        int odd=0;
        int even=0;
        int n=ar.length;
        for(int a:ar){
            if(a%2==0){
                even++;
            }else{
                odd++;
            }
        }
        if(odd==n||even==n){
            return true;
        }
        return false;

    }
}