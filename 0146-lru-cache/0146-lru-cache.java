class LRUCache {
    class Node{
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }

    }

    private Node head;
    private Node tail;

    private HashMap<Integer,Node> map;

    private int size;
    private int curr = 0;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        size = capacity;
        head = null;
        tail = null;

    }
    
    public int get(int key) {
        if(map.containsKey(key)){
        Node temp = map.get(key);
        if(temp == tail) return temp.value;
        if(temp == head){
            tail.next = temp;
             temp.prev = tail;
              tail = temp;
              head = head.next;
              head.prev = null;
              temp.next = null;
              return temp.value;
        }
        else{
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        tail.next = temp;
        temp.prev = tail;
        temp.next = null;
        tail = temp;

        return temp.value;
        }
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {

        Node temp = map.get(key);
        temp.value = value;

        // If already most recently used
        if (temp == tail) {
            return;
        }

        // Remove temp from its current position
        if (temp == head) {
            head = head.next;
            head.prev = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        // Move temp to tail
        tail.next = temp;
        temp.prev = tail;
        temp.next = null;
        tail = temp;

        return;
    }
        if(curr == size){
            if (head == tail) {
             map.remove(head.key);
                head = null;
                tail = null;
}             else {
             map.remove(head.key);
               head = head.next;
              head.prev = null;
        }
        curr--;
}
        
        Node newnode = new Node(key,value);
        if(head == null){
        head = newnode;
        tail = newnode;
        }
        else{
            tail.next = newnode;
            newnode.prev = tail;
            tail = newnode;
        }

        map.put(key,newnode);

        curr++;
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */