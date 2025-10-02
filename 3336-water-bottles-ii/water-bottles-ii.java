class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int empty=0;
        int drunk=0;
        while(numBottles>=numExchange||empty>=numExchange||numBottles>0){
            if(empty>=numExchange){
                empty-=numExchange;
                numBottles++;

                numExchange+=1;
            }
            else{
                drunk+=numBottles;
                empty+=numBottles;
                numBottles=0;
            }
        }
        return drunk;

    }
}