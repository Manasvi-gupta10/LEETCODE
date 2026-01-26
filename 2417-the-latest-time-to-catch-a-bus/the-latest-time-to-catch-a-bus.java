class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int n=buses.length;
        int m=passengers.length;
        int used=0;
        int i=0;
        for(int j=0;j<n;j++){
            used=0;
            while(i<m&&passengers[i]<=buses[j]&&used<capacity){
                used++;
                i++;
            }

        }
        int ans=0;
        if(used<capacity){
            ans=buses[n-1];
        }else{
            ans=passengers[i-1]-1;
        }
        HashSet<Integer> set=new HashSet<>();
        for(int j=0;j<m;j++){
            set.add(passengers[j]);
        }
        while(set.contains(ans)){
            ans--;
        }
        return ans;
    }
}