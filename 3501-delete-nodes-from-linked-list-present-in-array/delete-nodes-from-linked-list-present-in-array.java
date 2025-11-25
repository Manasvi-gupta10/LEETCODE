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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> ls=new HashSet<>();
        ListNode temp=head;
        for(int i=0;i<nums.length;i++){
            ls.add(nums[i]);
        }
        ListNode an=new ListNode(0);
        ListNode ans=an;
        while(temp!=null){
            if(!ls.contains(temp.val)){
                an.next=temp;
                an=an.next;
            }
            temp=temp.next;
        }
        an.next=null;
        return ans.next;
        
    }
}