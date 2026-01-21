class Solution {
    public int largestVariance(String s) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()) freq[c-'a']++;

        int ans = 0;

        for(char x = 'a'; x <= 'z'; x++){
            for(char y = 'a'; y <= 'z'; y++){
                if(x == y) continue;
                if(freq[x-'a'] == 0 || freq[y-'a'] == 0) continue;

                ans = Math.max(ans, kadane(s, x, y));
                ans = Math.max(ans, kadane(new StringBuilder(s).reverse().toString(), x, y));
            }
        }
        return ans;
    }

    private int kadane(String s, char x, char y){
        int cur = 0, ans = 0;
        int remainingY = 0;
        boolean hasY = false;

        for(char c : s.toCharArray())
            if(c == y) remainingY++;

        for(char c : s.toCharArray()){
            if(c == x) cur++;
            else if(c == y){
                cur--;
                hasY = true;
                remainingY--;
            }

            if(hasY)
                ans = Math.max(ans, cur);

            
            if(cur < 0 && remainingY > 0){//agr remaining ni toh jo y tha uska lost hojayega aur mujhe atleast ek y chaiye hi
                cur = 0;
                hasY = false;
            }
        }
        return ans;
    }
}
