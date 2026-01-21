class Solution {
    public int primeSubarray(int[] nums, int k) {
        int n=nums.length;
        int ei=0;
        int si=0;
        int ans=0;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        ArrayList<Integer> ls=new ArrayList<>();
        while(ei<n){
            if(prime(nums[ei])){
                map.put(nums[ei],map.getOrDefault(nums[ei],0)+1);
                ls.add(ei);
            }
            while(map.size()>=2&&map.lastKey()-map.firstKey()>k){
                if(prime(nums[si])){
                    map.put(nums[si],map.get(nums[si])-1);
                    if(map.get(nums[si])==0){
                        map.remove(nums[si]);
                    }
                }
                si++;
            }
            int m=ls.size();
            if(m>=2){//jb km se km  do prime sho
                int secl=ls.get(m-2);
                if(si<=secl){//true hai toh do primes honge hi — ye aur largest wala
                    //kyuki second element se ei tak wali subarrays invalid hoti hain
                    ans+=secl-si+1;
                    
                }
            }
            ei++;
        }
        return ans;
    }
    public boolean prime(int n){
        if(n<2){
            return false;
        }
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}