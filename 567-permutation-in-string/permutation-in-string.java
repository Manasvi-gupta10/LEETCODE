class Solution {
    public boolean checkInclusion(String s1, String s2) {
       int n1=s1.length(),n2=s2.length();
       if(n1>n2){
        return false;
       }
       int[] f1=new int[26];
       int[] f2=new int[26];
       for(int i=0;i<n1;i++){
          f1[s1.charAt(i)-'a']++;
       }
       //fixed size sliding window if size n1 across s2
       for(int i=0;i<n1;i++){
           f2[s2.charAt(i)-'a']++;
       }
       if(ismatch(f1,f2)){
         return true;
       }
       for(int i=n1;i<n2;i++){
           f2[s2.charAt(i)-'a']++;//sliding window m add horha
           f2[s2.charAt(i-n1)-'a']--;//sliding window se hat rha
            if(ismatch(f1,f2)){// ab 2 2 ki hi substring ayegi s2 me se har baar
              return true;
            }
       }
       return false;

    }
    public boolean ismatch(int[] a1,int[] a2){
        for(int i=0;i<26;i++){
            if(a1[i]!=a2[i]){
                return false;
            }
        }
        return true;
    }
    
}