class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        ArrayList<int[]> ls=new ArrayList<>();
        int i=0;
        while(i<n&&intervals[i][1]<newInterval[0]){
            ls.add(intervals[i]);
            i++;
        }
        while(i<n&&intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        ls.add(newInterval);
        while(i<n){
            ls.add(intervals[i]);
            i++;
        }
        int[][] ans=new int[ls.size()][2];
        for(int j=0;j<ls.size();j++){
            ans[j][0]=ls.get(j)[0];
            ans[j][1]=ls.get(j)[1];
        }
        return ans;
    }
}