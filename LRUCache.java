import java.util.HashMap;
public class LRUCache {
    public static void main(String args[]){
        DesignLRU obj = new DesignLRU(2);
        obj.put(1, 1);
        obj.put(2,2);
        obj.get(1);    // return 1
        obj.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        obj.get(2);    // returns -1 (not found)
        obj.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        obj.get(1);    // return -1 (not found)
        obj.get(3);    // return 3
        obj.get(4);    // return 4;
    }
}

class DesignLRU{
    //since we are using doubly linked list we have to make a node which consists of
    // two integer values and a next pointer and a prev pointer;
    static class Node{
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public static Node head = new Node(0,0);
    public static Node tail = new Node(0,0);
    int size;

    HashMap<Integer, Node> map = new HashMap<>();
    public DesignLRU(int capacity){
        size = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public void delete(Node node){
        map.remove(node);
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void insert(Node node){
        map.put(node.key, node);
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
    }
    public int get(int key){
        if(map.containsKey(key)){
            Node curr = map.get(key);
            delete(curr);
            insert(curr);
            return curr.value;
        }
        else{
            return -1;
        }
    }

    public void put(int key, int value){
        if(map.containsKey(key)){ //ya toh woh number pehle se hi hai hamare map mein;
            delete(map.get(key));
        }
        if(map.size() == size){  // ya toh map full ho chuki hai size of the map == 2;
            delete(tail.prev);
        }
        insert(new Node(key, value));
    }
}
