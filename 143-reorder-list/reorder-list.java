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
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

        }
        ListNode t=slow.next;
        slow.next=null;
        Stack<ListNode> st=new Stack<>();
        while(t!=null){
            st.push(t);
            t=t.next;
        }
        t=head;
        while(!st.isEmpty()){
            ListNode prv=t.next;
            ListNode stk=st.pop();
            t.next=stk;
            stk.next=prv;
            t=prv;
            
           
        }
    }
}