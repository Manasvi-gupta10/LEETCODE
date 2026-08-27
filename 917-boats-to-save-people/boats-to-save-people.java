class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n=people.length;
        int i=0;
        int b=0;
        int j=n-1;
        int curlim=0;
        while(i<=j){
            if(people[i]+people[j]<=limit){
                i++;
                j--;
                b++;
            }else{
                b++;
                j--;
            }
        }
        
        return b;
    }
}