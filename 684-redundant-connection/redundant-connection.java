class Solution {
    class disjoint{
        class node{
            int val;
            int rank;
            node parent;
            
        }
        private HashMap<Integer,node> map=new HashMap<>();
        public void create(int v){
            node nn=new node();
            nn.val=v;
            nn.rank=0;
            nn.parent=nn;
            map.put(v,nn);
        }
        public int find(int v){
            node n=map.get(v);
            return find(n).val;
        }
        private node find(node n){
            if(n.parent==n){
                return n;
            }
            node fn=find(n.parent);
            n.parent=fn;
            return fn;
        }
        public void union(int e1,int e2){
            node n1=map.get(e1);
            node n2=map.get(e2);
            node rep1=find(n1);
            node rep2=find(n2);
            if(rep1.rank==rep2.rank){
                rep1.parent=rep2;
                rep2.rank++;
            }else if(rep1.rank<rep2.rank){
                rep1.parent=rep2;
            }else{
                rep2.parent=rep1;
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int[] ans=new int[2];
        disjoint d=new disjoint();
        int n=edges.length;
        for(int i=1;i<=n;i++){
            d.create(i);
        }
        for(int[] a:edges){
            int r1=d.find(a[0]);
            int r2=d.find(a[1]);
            if(r1==r2){
                ans[0]=a[0];
                ans[1]=a[1];
            }else{
                d.union(a[0],a[1]);
            }
        }
        return ans;
    }
}