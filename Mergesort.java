public class Mergesort {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;

    public static void displaylinkedList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    private static Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static Node merge(Node head1, Node head2){
        Node mergedll = new Node(-1);
        Node temp = mergedll;

        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedll.next;
    }

    public static Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        //find mid
        Node mid = getMid(head);

        //division of linked list into left-half and right-half
        Node rightHead = mid.next;
        mid.next = null;

        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        return merge(newLeft, newRight);
    }
    public static void main(String args[]){
        head = new Node(6);
        Node n1 = new Node(3);
        head.next = n1;
        Node n2 = new Node(9);
        n1.next = n2;
        Node n3 = new Node(8);
        n2.next = n3;
        Node n4 = new Node(2);
        n3.next = n4;
        Node n5 = new Node(5);
        n4.next = n5;
        n5.next = null;
        displaylinkedList(head);
        Node newHead = mergeSort(head);
        displaylinkedList(newHead);
    }
}
