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
    class pair{
        ListNode cur;
        ListNode hd;
        public pair(ListNode cur,ListNode hd){
            this.cur=cur;
            this.hd=hd;
        }
    }
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        pair p=rev(head);
        p.cur=null;
        return p.hd;
    }
    public pair rev(ListNode head){
        if(head.next==null){
            return new pair(head,head);
        }
        pair p=rev(head.next);
        head.next=null;
        p.cur.next=head;
        return new pair(head,p.hd);
    }

}