
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int n=employees.size();
        HashMap<Integer,Employee> map=new HashMap<>();
        for(int i=0;i<n;i++){
            Employee em=employees.get(i);
            map.put(em.id,em);
        }
        return fun(id,map);

    }
    public int fun(int id,HashMap<Integer,Employee> map){
        Employee em=map.get(id);
            int ans=em.importance;
            for(int i=0;i<em.subordinates.size();i++){
                ans+=fun(em.subordinates.get(i),map);
            }
            return ans;
    }
}