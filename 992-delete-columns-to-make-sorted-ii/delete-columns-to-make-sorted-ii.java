class Solution {
    public int minDeletionSize(String[] strs) {
        int n=strs.length;
        boolean[] ar=new boolean[n-1];
        int c=strs[0].length();
        int ans=0;
        for(int i=0;i<c;i++){
            boolean isdel=false;
            for(int j=0;j<n-1;j++){
                if(!ar[j]&&strs[j].charAt(i)>strs[j+1].charAt(i)){
                    isdel=true;
                    break;
                }
            }
            if(isdel){
                ans++;
            }else{
                for (int k = 0; k < n - 1; k++) {
        if (strs[k].charAt(i) < strs[k + 1].charAt(i)) {
            ar[k] = true;
        }
    }
            }
        }
        return ans;
        
    }
}