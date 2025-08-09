class Solution {
    public String largestMerge(String word1, String word2) {
        int n1=word1.length();
        int n2=word2.length();
        StringBuilder ans=new StringBuilder();
        int i=0,j=0;
        while(i<n1&&j<n2){
            if(word1.charAt(i)>word2.charAt(j)){
                ans.append(word1.charAt(i));
                i++;
            }else if(word1.charAt(i)<word2.charAt(j)){
                ans.append(word2.charAt(j));
                j++;
            }else{
                
                if(greater(word1,word2,i,j)){
                    ans.append(word1.charAt(i));
                i++;
                }else{
                   ans.append(word2.charAt(j));
                j++;
                }
            }
           
        }
        while(i<n1){
            ans.append(word1.charAt(i));
                i++;
        }
        while(j<n2){
             ans.append(word2.charAt(j));
                j++;
        }
         return ans.toString();
    }
    public boolean greater(String s1,String s2,int i,int j){
        while(i<s1.length()&&j<s2.length()){
            if(s1.charAt(i)>s2.charAt(j)){
                return true;
            }
            if(s1.charAt(i)<s2.charAt(j)){
                return false;
            }
            i++;
            j++;
        }
        return j==s2.length();
    }
}