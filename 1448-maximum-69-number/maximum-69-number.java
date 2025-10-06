class Solution {
    public int maximum69Number (int num) {
        StringBuilder sb=new StringBuilder(num);
        sb.append(num);
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='6'){
                sb.deleteCharAt(i);
                sb.insert(i,'9');
                break;
            }
        }
        System.out.println(sb);
        return Integer.parseInt(sb.toString());
        //return 0;
    }
}