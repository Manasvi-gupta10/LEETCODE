class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=1;i<=n;i++){
            map.put(i,new ArrayList<>());
        }
        int[] deg=new int[n+1];
        for(int i=0;i<edges.size();i++){
            int u=edges.get(i).get(0);
            int v=edges.get(i).get(1);
            deg[u]++;
            deg[v]++;
            map.get(u).add(v);
            map.get(v).add(u);

        }
        List<Integer> ls=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(deg[i]%2!=0){
                ls.add(i);
            }
        }
        //edges add hongi 2 vertex k beechme if odd aesi vertex jinki degree odd toh ek rh hi jayegi jiska deg kabh bhi even ni ho payegi
        //almost 2 add krnu toh 4 hi hoksti ..6 k liye km se km 3 chaiye 
        if(ls.size()%2!=0||ls.size()>4){
            return false;
        }
        //agr 2 ki deg odd ya do unme hi lgado edges used 1
        //ya un do ki aesi se jisse dono hi na ho wha 2 use hongi
        if(ls.size()==2){
            int u=ls.get(0);
            int v=ls.get(1);
            if(!map.get(u).contains(v)){
                return true;
            }else{
                int i=1;
                for(;i<=n;i++){
                    if(i==u||i==v){
                        continue;
                    }
                    if(!map.get(i).contains(u)&&!map.get(i).contains(v)){
                        return true;
                    }
                }
                if(i==n+1){
                    return false;
                }

            }
            //4 hai toh unme hi aaps m toh yha 2 edges use hojayengi in 4 ki sbse ni as usme 4 edges chaiye hongi
        }else if(ls.size()==4){
            int a=ls.get(0);
            int b=ls.get(1);
            int c=ls.get(2);
            int d=ls.get(3);
            if((!map.get(a).contains(b)&&!map.get(c).contains(d))||(!map.get(a).contains(c)&&!map.get(b).contains(d))||(!map.get(a).contains(d)&&!map.get(c).contains(b))){
                return true;
            }else{
                return false;
            }
        }
        
        return true;
        

        
    }
}