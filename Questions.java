public class Questions {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public static boolean detectCycle(Node head){
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

    public static void removeCycle(Node head){
        Node slow = head, fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }

        slow = head;
        Node prev = null;

        while(slow != fast){
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }
        prev.next = null;
    }
    
    public static Node findMiddle(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node merge(Node head1, Node head2){
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

    }
    public static Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }

        //getting the correct middle
        Node midNode = findMiddle(head);
        
        //division
        Node rH = midNode.next;
        midNode.next = null;
        Node lefthead = mergeSort(head);
        Node righthead = mergeSort(rH);

        return merge(lefthead, righthead);
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
        Node n5 = new Node(6);
        n4.next = n5;
        n5.next = n2;
        System.out.println(detectCycle(head));
        removeCycle(head);
        System.out.println(detectCycle(head));

    }
}
