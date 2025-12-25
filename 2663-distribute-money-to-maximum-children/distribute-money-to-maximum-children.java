class Solution {
    public int distMoney(int money, int children) {
        if(money<children){
            return -1;
        }
        money-=children;
        int maxc=Math.min(money/7,children);

        money-=maxc*7;
        children-=maxc;
        if(money==3&&children==1){
            maxc--;
        }
        if (children == 0 && money > 0) {
            maxc--;
        }

        return maxc;
        
    }
}