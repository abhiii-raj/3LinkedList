public class DeleteMAfterN {
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
    public static Node head1;
    public static Node tail1;

    public static void addLast(Node curr){
        tail1.next = curr;
        tail1= curr;
    }
    public static Node addNodes(Node curr, int m){
        while(curr != null && m > 0){
            Node next = curr.next;
            curr.next = null;
            addLast(curr);
            curr = next;
            m--;
        }
        return curr;
    }
    public static Node deleteNodes(Node head, int m , int n){
        Node mergedll = new Node(-1);

        head1 = mergedll;
        tail1 = mergedll;

        Node curr = head;
        int N = n;

        while(curr != null){
            curr = addNodes(curr, m);

            while(N > 0 && curr != null){
                curr = curr.next;
                N--;
            }
            N = n;
        }
        return mergedll.next;
    }
    public static void main(String args[]){
        addFirst(9);
        addFirst(8);
        addFirst(7);
        addFirst(6);
        addFirst(5);
        addFirst(4);
        addFirst(3);
        addFirst(2);
        addFirst(1);
        display(head);
        Node newHead = deleteNodes(head, 3, 2);
        display(newHead);
    }
}
