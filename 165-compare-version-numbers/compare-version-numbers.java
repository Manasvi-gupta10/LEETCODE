class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");
        int i=0,j=0;
        while(i<v1.length&&j<v2.length){
            int f=Integer.parseInt(v1[i]);
            int s=Integer.parseInt(v2[j]);
            if(f-s!=0){
                if(f>s){
                    return 1;
                }else{
                    return -1;
                }
            }
            i++;
            j++;
        }
        int f=0;
        while(i<v1.length){
            int s=Integer.parseInt(v1[i]);
            if(f-s!=0){
                if(s>f){
                    return 1;
                }else{
                    return -1;
                }
            }
            i++;
        }
        while(j<v2.length){
            int s=Integer.parseInt(v2[j]);
            if(f-s!=0){
                if(f>s){
                    return 1;
                }else{
                    return -1;
                }
            }
            j++;
        }
        
        return 0;
    }
}