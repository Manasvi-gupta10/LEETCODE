class Solution {
    public int minOperations(int n, int m) {
        String s=n+"";
        int d=s.length();
        int mx=(int)Math.pow(10,d);
        int[] pr=allprimes(mx-1);
        if(pr[n]==0||pr[m]==0){
            return -1;
        }
        int[] dis = new int[mx];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[n] = n;

        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        
        pq.add(new pair(n,n));
        while(!pq.isEmpty()){
    pair r = pq.poll();

    if(r.num == m) return r.cost;
    if(r.cost > dis[r.num]) continue;

    char[] car = String.format("%0" + d + "d", r.num).toCharArray();

    for(int i = 0; i < d; i++){
        char original = car[i];

        if(original < '9'){
            car[i] = (char)(original + 1);
            if(car[0]!='0'){
                int num = Integer.parseInt(new String(car));
            if(pr[num] == 1){
                int nc = r.cost + num;
                if(nc < dis[num]){
                    dis[num] = nc;
                    pq.add(new pair(num, nc));
                }
            }
            }
        }

        car[i] = original;

        if(original > '0'){
            car[i] = (char)(original - 1);
            if(car[0]!='0'){
                int num = Integer.parseInt(new String(car));
            if(pr[num] == 1){
                int nc = r.cost + num;
                if(nc < dis[num]){
                    dis[num] = nc;
                    pq.add(new pair(num, nc));
                }
            }
            }
        }

        car[i] = original;
    }
}

        return -1;
        
    }
    public int[] allprimes(int n){
        
        int[] ar=new int[n+1];
        ar[0]=ar[1]=1;
        for(int i=2;i*i<=n;i++){
            if(ar[i]==0){
                for(int j=2;i*j<=n;j++){
                    ar[i*j]=1;
                }
            }
        }
        return ar;
    }
}
class pair{
    int num;
    int cost;
    public pair(int num,int cost){
        this.num=num;
        this.cost=cost;
    }
}