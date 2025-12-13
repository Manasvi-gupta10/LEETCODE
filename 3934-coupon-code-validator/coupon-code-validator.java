class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        List<String> ans=new ArrayList<>();
        HashSet<String> set=new HashSet<>();
        set.add("electronics");
        set.add("grocery");
        set.add("pharmacy");
        set.add("restaurant");
        int n=code.length;
        HashMap<String,ArrayList<String>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(isActive[i]==false||!set.contains(businessLine[i])||!code[i].matches("[a-zA-Z0-9_]+")){
                continue;
            }
            if(!map.containsKey(businessLine[i])){
                map.put(businessLine[i],new ArrayList<>());
            }
            map.get(businessLine[i]).add(code[i]);

        }
        if(map.containsKey("electronics")){
            ArrayList<String> l=map.get("electronics");
            Collections.sort(l);
            for(int i=0;i<l.size();i++){
                ans.add(l.get(i));
            }
        }
        if(map.containsKey("grocery")){
            ArrayList<String> l=map.get("grocery");
            Collections.sort(l);
            for(int i=0;i<l.size();i++){
                ans.add(l.get(i));
            }
        }
        if(map.containsKey("pharmacy")){
            ArrayList<String> l=map.get("pharmacy");
            Collections.sort(l);
            for(int i=0;i<l.size();i++){
                ans.add(l.get(i));
            }
        }
        if(map.containsKey("restaurant")){
            ArrayList<String> l=map.get("restaurant");
            Collections.sort(l);
            for(int i=0;i<l.size();i++){
                ans.add(l.get(i));
            }
        }

        
        return ans;
        
    }
}