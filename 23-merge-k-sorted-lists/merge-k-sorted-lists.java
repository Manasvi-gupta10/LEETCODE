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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode o1,ListNode o2){
                return o1.val-o2.val;
            }
        });
        int n=lists.length;
        for(int i=0;i<n;i++){
            if(lists[i]!=null){
                pq.add(lists[i]);
            }
        }
        ListNode nn=new ListNode();
        ListNode ans=nn;
        while(!pq.isEmpty()){
            ListNode r=pq.poll();
            nn.next=r;
            nn=nn.next;
            if(r.next!=null){
                pq.add(r.next);
            }
        }
        return ans.next;
    }
}