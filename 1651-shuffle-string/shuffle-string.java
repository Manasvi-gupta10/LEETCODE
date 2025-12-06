class Solution {
    public String restoreString(String s, int[] indices) {
        int n=s.length();
        char[] ar=new char[n];
        for(int i=0;i<n;i++){
            ar[indices[i]]=s.charAt(i);
        } 
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(ar[i]);
        }
        return sb.toString();
    }
}