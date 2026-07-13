class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        long minl = len(low);
        long maxl = len(high);
        List<Integer> ans = new ArrayList<>();

        StringBuilder s = string1((int) minl);

        long num = Long.parseLong(s.toString());
        if(num>=low&&num<=high){
                    ans.add((int) num);
                }

        long c = minl + 1;

        while (minl <= maxl && num <= high) {
            if (c <= 9) {
                s.deleteCharAt(0);
                s.append(c);
                num = Long.parseLong(s.toString());
                if(num>=low&&num<=high){
                    ans.add((int) num);
                }
                c++;
            } else {
                minl++;
                s = string1((int) minl);
                num = Long.parseLong(s.toString());
                if(num>=low&&num<=high){
                    ans.add((int) num);
                }
                c = s.length() + 1;
            }
        }

        //ans.remove(ans.size() - 1);
        return ans;
    }

    public StringBuilder string1(int minl) {
        int c = 1;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < minl) {
            sb.append(c);
            c++;
        }
        return sb;
    }

    public long len(long n) {
        long l = 0;
        while (n > 0) {
            l++;
            n /= 10;
        }
        return l;
    }
}