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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        int c=0;
        while(temp!=null){
            c++;
            temp=temp.next;

        }
        int itr=c/k;
        temp=head;
        ListNode t=head;
        ListNode an=new ListNode(0);
        ListNode ans=an;
        while(itr-->0){
            for(int i=0;i<k;i++){
                t=t.next;
            }
            ListNode nn=rev(temp,k);
            an.next=nn;
            temp=t;
            for(int i=0;i<k;i++){
                an=an.next;
            }
            
        }
        if(temp!=null){
            an.next=temp;
        }
        return ans.next;
    }
    public ListNode rev(ListNode head, int k){
        ListNode prev=null;
        ListNode cur=head;
        while(k-->0){
            ListNode ahead=cur.next;
            cur.next=prev;
            prev=cur;
            cur=ahead;
        }
        return prev;
    }
}