public class Zigzaglist {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    public static void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public static void display(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    private static Node findMiddle(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    public static void zigZag(Node head){
        Node mid = findMiddle(head);
        
        //division of ll into two halves
        Node rh = mid.next;
        mid.next = null;

        //reversing the right-half
        Node prev = null;
        Node curr = rh;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL;
        Node nextR;

        while(left != null && right != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;
            
            right = nextR;
            left = nextL;
        }

    }
    public static void main(String args[]){
        addFirst(6);
        addFirst(5);
        addFirst(4);
        addFirst(3);
        addFirst(2);
        addFirst(1);
        display(head);
        zigZag(head);
        display(head);
    }
}
