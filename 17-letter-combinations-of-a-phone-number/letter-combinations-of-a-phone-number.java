class Solution {
    static String[] phn={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ls=new ArrayList<>();
        comb(digits,ls,"");
        return ls;
        
    }
    public void comb(String d,List<String> ls,String ans){
        if(d.length()==0){
            ls.add(ans);
            return;
        }

        char ch=d.charAt(0);
        String tr=phn[ch-'0'];
        for(int i=0;i<tr.length();i++){
            comb(d.substring(1),ls,ans+tr.charAt(i));
        }
    }
}