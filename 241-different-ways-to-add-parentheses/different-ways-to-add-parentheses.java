class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return paran(expression,0,expression.length()-1);
    }
    public List<Integer> paran(String s,int i,int j){
        List<Integer> ls=new ArrayList<>();
        if(isnumeric(s.substring(i,j+1))){
             ls.add(Integer.parseInt(s.substring(i,j+1)));
             return ls;
        }

        
        for(int in=i;in<=j;in++){
            if(s.charAt(in)=='+'||s.charAt(in)=='*'||s.charAt(in)=='-'){
                List<Integer> l=paran(s,i,in-1);
                List<Integer> r=paran(s,in+1,j);
                for(int li:l){
                    for(int ri:r){
                        if(s.charAt(in)=='+'){
                            ls.add(li+ri);
                        }else if(s.charAt(in)=='-'){
                            ls.add(li-ri);
                        }else if(s.charAt(in)=='*'){
                            ls.add(li*ri);
                        }
                    }
                }
            }
        }
        return ls;
    }
    public boolean isnumeric(String s){
        if(s==null||s.length()==0){
            return false;
        }
        try{
            Integer.parseInt(s);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}