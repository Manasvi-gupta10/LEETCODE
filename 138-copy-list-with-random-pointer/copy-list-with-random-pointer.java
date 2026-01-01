/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    HashMap<Node,Node> map=new HashMap<>();
    public Node copyRandomList(Node head) {
        if(map.containsKey(head)){
            return map.get(head);
        }
        if(head==null){
            return null;
        }
        Node nn=new Node(head.val);
        map.put(head,nn);
        nn.next=copyRandomList(head.next);
        nn.random=copyRandomList(head.random);
        return nn;    
    }
}