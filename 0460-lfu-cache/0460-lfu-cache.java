import java.util.*;

class LFUCache {

    // ---------------- NODE ----------------
    class Node {
        int key;
        int value;
        int freq;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    // ---------------- DOUBLY LINKED LIST ----------------
    class List {
        int size;
        Node head;
        Node tail;

        List() {
            head = new Node(0, 0); // dummy head
            tail = new Node(0, 0); // dummy tail

            head.next = tail;
            tail.prev = head;

            size = 0;
        }

        // Add node at front
        void addFront(Node node) {

            Node temp = head.next;

            node.next = temp;
            node.prev = head;

            head.next = node;
            temp.prev = node;

            size++;
        }

        // Remove a particular node
        void removeNode(Node node) {

            Node prevNode = node.prev;
            Node nextNode = node.next;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;

            size--;
        }

        // Remove least recently used node
        Node removeLast() {

            if (size == 0) {
                return null;
            }

            Node node = tail.prev;

            removeNode(node);

            return node;
        }
    }

    // key -> Node
    private HashMap<Integer, Node> keyNode;

    // frequency -> Doubly Linked List
    private HashMap<Integer, List> freqListMap;

    private int maxSizeCache;
    private int minFreq;
    private int curSize;

    // ---------------- CONSTRUCTOR ----------------
    public LFUCache(int capacity) {

        maxSizeCache = capacity;
        minFreq = 0;
        curSize = 0;

        keyNode = new HashMap<>();
        freqListMap = new HashMap<>();
    }

    // ---------------- UPDATE FREQUENCY ----------------
    private void updateFreqListMap(Node node) {

        int oldFreq = node.freq;

        // Remove node from old frequency list
        List oldList = freqListMap.get(oldFreq);
        oldList.removeNode(node);

        // If this was the minimum frequency
        // and no node remains at this frequency
        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        // Increase frequency
        node.freq++;

        // Get list for new frequency
        List newList = freqListMap.get(node.freq);

        if (newList == null) {
            newList = new List();
            freqListMap.put(node.freq, newList);
        }

        // Add node to front
        newList.addFront(node);
    }

    // ---------------- GET ----------------
    public int get(int key) {

        if (!keyNode.containsKey(key)) {
            return -1;
        }

        Node node = keyNode.get(key);

        // get() increases frequency
        updateFreqListMap(node);

        return node.value;
    }

    // ---------------- PUT ----------------
    public void put(int key, int value) {

        // Capacity = 0
        if (maxSizeCache == 0) {
            return;
        }

        // Key already exists
        if (keyNode.containsKey(key)) {

            Node node = keyNode.get(key);

            // Update value
            node.value = value;

            // put() also increases frequency
            updateFreqListMap(node);

            return;
        }

        // Cache is full
        if (curSize == maxSizeCache) {

            // Get list having minimum frequency
            List list = freqListMap.get(minFreq);

            // Remove LRU node
            Node nodeToRemove = list.removeLast();

            // Remove from key -> Node map
            keyNode.remove(nodeToRemove.key);

            curSize--;
        }

        // Create new node
        Node newNode = new Node(key, value);

        // New node always has frequency 1
        minFreq = 1;

        // Get frequency 1 list
        List listFreq = freqListMap.get(1);

        if (listFreq == null) {
            listFreq = new List();
            freqListMap.put(1, listFreq);
        }

        // Add new node to front
        listFreq.addFront(newNode);

        // Add to key map
        keyNode.put(key, newNode);

        curSize++;
    }
}