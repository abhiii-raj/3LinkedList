public class Circularlist {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;

    public static boolean checkCycle(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
    public static void main(String args[]){
        head = new Node(1);
        Node n1 = new Node(2);
        head.next = n1;
        Node n2 = new Node(3);
        n1.next = n2;
        Node n3 = new Node(4);
        n2.next = n3;
        Node n4 = new Node(5);
        n3.next = n4;
        n4.next = n1;  //last node points to the first node
        System.out.println(checkCycle(head)); 
        //if it is a cicular linked list then it must has a loop and in that condition it returns true;
    }
}
