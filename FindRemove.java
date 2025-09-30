public class FindRemove {
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

    public static void deleteNthNode(int n){
        int sz = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }
        // System.out.println(sz);
        if(n == sz){
            head = head.next;
            return;
        }
        // System.out.println(totalSize);
        int itoFind = sz - n;
        int i = 1;
        Node curr = head;
        while(i < itoFind){
            curr = curr.next;
            i++;
        }
        curr.next = curr.next.next;
    }
    public static void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String args[]){
        addFirst(1);
        addFirst(2);
        addFirst(3);
        addFirst(4);
        addFirst(5);
        display();
        deleteNthNode(4);
        display();
    }
}
