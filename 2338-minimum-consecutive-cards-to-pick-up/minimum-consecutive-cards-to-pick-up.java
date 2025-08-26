class Solution {
    public int minimumCardPickup(int[] cards) {
        int n=cards.length;
        int ans=Integer.MAX_VALUE;
        int e=0,s=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(e<n){
            if(map.containsKey(cards[e])){
                ans=Math.min(ans,e-map.get(cards[e])+1);
                map.put(cards[e],e);
            }
           else{
            map.put(cards[e],e);
           }
            e++;
        }
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
}