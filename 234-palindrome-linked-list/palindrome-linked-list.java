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
    public boolean isPalindrome(ListNode head) {
       
        ListNode s=head;
        ListNode f=head;
        while(f!=null&&f.next!=null){
            s=s.next;
            f=f.next.next;
        }
        ListNode rv=rev(s);
        ListNode t=head;
        while(rv!=null){
            if(rv.val!=t.val){
                return false;
            }
            rv=rv.next;
            t=t.next;
        }
        return true;
    }
    public ListNode rev(ListNode head){
        ListNode cur=head;
        ListNode prv=null;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=prv;
            prv=cur;
            cur=next;
        }
        return prv;
    }
}