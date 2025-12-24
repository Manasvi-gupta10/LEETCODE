class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int n1=s1.length();
        int n2=s2.length();
        int n3=s3.length();
        int ml=Math.min(n1,Math.min(n2,n3));
        int eqsiz=0;
        for(int i=0;i<ml;i++){
            if(s1.charAt(i)==s2.charAt(i)&&s2.charAt(i)==s3.charAt(i)){
                eqsiz++;

            }else{
                break;
            }
        }
        if(eqsiz==0){
            return -1;
        }
        int ans=(n1-eqsiz)+(n2-eqsiz)+(n3-eqsiz);
        
        return ans;
        
    }
}