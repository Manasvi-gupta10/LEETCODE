class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans=numBottles;
        while(numBottles>=numExchange){
            int getfilled=numBottles/numExchange;
            int notexchanged=numBottles%numExchange;
            ans+=getfilled;
            numBottles=getfilled+notexchanged;
        }
        return ans;
    }
}