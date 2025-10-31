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
    //one pass
     public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null||head.next==null)
        {
            if(head.next==null&&n==1){//ek node aur wo delete krni toh null
                return null;
            }
            return head;
        }
         ListNode dummy = new ListNode(0); // Dummy node to handle edge cases
        dummy.next = head;//linking dummy node with val 0 with head node of list
        ListNode slow=dummy;
         ListNode fast=dummy;
         //This ensures that when fast reaches the end (null), slow is just before the node to delete....moving fast with n+1 steps ahead slow
         //mtlb slow aur fast k beech me n ka gap hai toh agr fast null hoga toh slow k bad nth node hi hogi 
         for(int i=0;i<=n;i++){
            fast=fast.next;
         }
         while(fast!=null){
            fast=fast.next;
            slow=slow.next;
         }
         slow.next=slow.next.next;//skip nth node
         return dummy.next;
     }

    /**2pass solution 
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null||head.next==null)
        {
            if(head.next==null&&n==1){//ek node aur wo delete krni toh null
                return null;
            }
            return head;
        }
        int l=0;//total nodes in list
        ListNode temp=head;
        while(temp!=null){
            l++;
            temp=temp.next;
        }
        if(l==n){//length equal to peeche s jha s delte krni toh first wla delete isiliye head.next 
            return head.next;
        }
        n=l-n-1;//starting s jo node delet krni usse phle wli
        temp=head;
        for(int i=0;i<n&&temp!=null;i++){
            temp=temp.next;

        }
        temp.next=temp.next.next;
        return head;

    }**/
}