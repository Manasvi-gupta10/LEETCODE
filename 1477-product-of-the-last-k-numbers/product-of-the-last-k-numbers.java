
class ProductOfNumbers {
    ArrayList<Integer> ls=new ArrayList<>();
    public ProductOfNumbers() {
        
    }
    
    public void add(int num) {
        ls.add(num);
    }
    
    public int getProduct(int k) {
        int ans=1;
        int n=ls.size();
        for(int i=n-1;i>=n-k;i--){
            ans*=ls.get(i);
        }
        return ans;
        
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */