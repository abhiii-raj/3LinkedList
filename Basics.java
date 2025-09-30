public class Basics{
    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public static void addFirst(int data){
        if(head == null){
            head = tail = new Node(data);
            return;
        }

        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public static void addLast(int data){
        if(head == null){
            head = new Node(data);
            return;
        }

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node newNode = new Node(data);
        temp.next = newNode;
        newNode.next = null;
    }
    public static void display(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    public static void main(String args[]){
        addFirst(1);
        addFirst(2);
        addFirst(3);
        addFirst(4);
        display(head);
        System.out.println();
        addLast(0);
        display(head);
    }
}