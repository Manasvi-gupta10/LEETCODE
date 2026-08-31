/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
         int[] ans=new int[2];
        Arrays.fill(ans,-1);
        ListNode temp=head;
        ListNode prev=temp;
        temp=temp.next;
        if(temp==null||temp.next==null){
            return ans;
        }
        int in=2;
        List<Integer> ind=new ArrayList<>();
        while(temp.next!=null){
            ListNode nx=temp.next;
            if((prev.val>temp.val&&nx.val>temp.val)||(prev.val<temp.val&&nx.val<temp.val)){
                ind.add(in);
            }
            in++;
            prev=temp;
            temp=temp.next;

        }
      int sz=ind.size();
      if(sz==0||sz==1){
        return ans;
      }
       //System.out.println(ind);
        ans[1]=ind.get(sz-1)-ind.get(0);
        ans[0]=Integer.MAX_VALUE;
        for(int i=0;i<sz-1;i++){
            ans[0]=Math.min(ans[0],ind.get(i+1)-ind.get(i));
        }
        return ans;
        
    }
}