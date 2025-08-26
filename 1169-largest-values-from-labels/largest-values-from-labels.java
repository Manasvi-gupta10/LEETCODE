class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n=values.length;
        int[][] comb=new int[n][2];
        for(int i=0;i<n;i++){
            comb[i][0]=values[i];
            comb[i][1]=labels[i];
        }
        int ans=0;
        Arrays.sort(comb,(a,b)->b[0]-a[0]);
        int el=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int l=comb[i][1];
            map.put(l,map.getOrDefault(l,0)+1);
            if(map.get(l)<=useLimit&&el<numWanted ){
                System.out.println(comb[i][0]);
                ans+=comb[i][0];
                el++;
            }
        }
        return ans;
    }
}