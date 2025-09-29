class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int minc=0,minr=0,maxc=matrix[0].length-1,maxr=matrix.length-1;
        int c=0,n=matrix.length*matrix[0].length;
        List<Integer> an=new ArrayList<>();
        
        while(c<n){
            for(int i=minc;i<=maxc&&c<n;i++){
            an.add(matrix[minr][i]);
            
            c++;
        }
        minr++;
        for(int i=minr;i<=maxr&&c<n;i++){
            an.add(matrix[i][maxc]);
            c++;
        }
        maxc--;
        for(int i=maxc;i>=minc&&c<n;i--){
            an.add(matrix[maxr][i]);

            c++;
        }
        maxr--;
        for(int i=maxr;i>=minr&&c<n;i--){
            an.add(matrix[i][minc]);
            c++;
        }
        minc++;
        }
        return an;
    }
}