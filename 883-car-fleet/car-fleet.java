class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=speed.length;
        double[][] p=new double[n][2];
        for(int i=0;i<n;i++){
            p[i][0]=position[i];
            p[i][1]=(double)(target-position[i])/speed[i];
        }
        Arrays.sort(p,(a,b)->Double.compare(b[0],a[0]));
        int fleet=0;
        double prevt=0.0;
        for(int i=0;i<n;i++){
            if(p[i][1]>prevt){
                fleet++;
                prevt=p[i][1];
            }
        }
        return fleet;
    }
}