class LRUCache {

    private static class Node {
        int key, value;
        Node prev, next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final HashMap<Integer, Node> map;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);
        moveToFirst(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToFirst(node);
            return;
        }
        
        Node newNode = new Node(key, value);
        if(map.size() == capacity) {
            Node lastNode = tail.prev;
            removeNode(lastNode);
            map.remove(lastNode.key);
        }
        map.put(key, newNode);
        insertAtFirst(newNode);
    }

    private void moveToFirst(Node node) {
        removeNode(node);
        insertAtFirst(node);
    }

    private void insertAtFirst(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
