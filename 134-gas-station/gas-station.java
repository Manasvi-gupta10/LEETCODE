class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int tot=0;
        for(int i=0;i<n;i++){
            tot+=gas[i]-cost[i];
        }
        if(tot<0){
            return -1;
        }
        int in=0,tank=0;
        for(int i=0;i<n;i++){
            tank+=gas[i]-cost[i];
            if(tank<0){
                in=i+1;
                tank=0;
            }
        }
        return in;
    }
}