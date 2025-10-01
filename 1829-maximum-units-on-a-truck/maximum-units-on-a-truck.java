class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int n=boxTypes.length;
        Arrays.sort(boxTypes,(a,b)->Integer.compare(b[1],a[1]));
        for(int j=0;j<n;j++){
            System.out.println(boxTypes[j][0]+" "+boxTypes[j][1]);
        }
        int ans=0;
        int i=0;
        while(truckSize>0&&i<n){
            int box=boxTypes[i][0];
            int units=boxTypes[i][1];
            if(truckSize>=box){
                ans+=(box*units);
                truckSize-=box;

            }else if(truckSize>0){
                int b=truckSize%box;
                ans+=(b*units);
                truckSize-=b;
            }
            i++;

        }
        return ans;
    }
}