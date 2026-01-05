class Solution {
    public int minimumBuckets(String s) {
        int ans = 0;
        int n = s.length();
        char[] ch= s.toCharArray();
        for(int i = 0 ; i < n ; i++){
            if(ch[i] == 'H'){
                if((i+1 < n && ch[i+1] == 'f') || (i-1 >= 0 && ch[i-1] == 'f')) continue;
                else if(i+1 < n && ch[i+1] == '.'){
                    ch[i+1] = 'f';
                    ans++;
                }else if(i-1 >= 0 && ch[i-1] == '.'){
                    ch[i-1] = 'f';
                    ans++;
                }else return -1;
           }
        }

        return ans;
    }
}