class Solution {
    String posmax="";
    public String largestTimeFromDigits(int[] arr) {
        boolean[] used=new boolean[4];
        maxtime(arr,"",used);
        if(posmax.equals("")){
            return "";
        }
        return posmax.substring(0,2)+":"+posmax.substring(2);

        
    }
    public void maxtime(int[] ar,String s,boolean[] used){
        if(s.length()==4){
            int h=Integer.parseInt(s.substring(0,2));
            int m=Integer.parseInt(s.substring(2));
            if(h<24&&m<60){
                if(posmax.equals("")||s.compareTo(posmax)>0){
                    posmax=s;
                }

            }
            return;
        }


        for(int i=0;i<4;i++){
            if(!used[i]){
                used[i]=true;
                maxtime(ar,s+ar[i],used);
                used[i]=false;
            }
        }
    }
}