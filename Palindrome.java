public class Palindrome {
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

    public static void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public static Node findMiddle(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    public static boolean checkPalindrome(){
        Node prev = null;
        Node curr = findMiddle();
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;

        while(right != null){
            if(left.data != right.data){
                return false;
            }
            else{
                left= left.next;
                right = right.next;
            }
        }
        return true;
    }
    public static void main(String args[]){
        addFirst(1);
        addFirst(2);
        addFirst(2);
        addFirst(3);
        System.out.println(checkPalindrome());
    }
}
