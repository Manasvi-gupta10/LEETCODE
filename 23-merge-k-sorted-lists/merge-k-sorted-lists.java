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
        int n=lists.length;
        if(n==0){
            return null;
        }
        //System.out.println(n);
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode l:lists){
            if(l!=null){
                pq.add(l);
            }
        }
        ListNode temp=new ListNode(0);
        ListNode cur=temp;
        while(!pq.isEmpty()){
            ListNode l=pq.poll();
            cur.next=l;
            cur=cur.next;
            if(l.next!=null){
                pq.add(l.next);
            }
        }
        return temp.next;
    }
}