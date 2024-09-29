class Node {
    Node next;
    Node prev;
    int freq;
    HashSet<String> keys;
    Node(int f){
        next = null;
        prev = null;
        freq = f;
        keys = new HashSet<>();
    }
}
class AllOne {
    HashMap<String, Node> map;
    Node head;
    Node tail;
    public AllOne() {
        head = new Node(0);
        tail = new Node(0);
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }
    
    public void inc(String key) {
        Node cur = head;
        int newFreq = 1;
        if(map.containsKey(key)){
            cur = map.get(key);
            newFreq = cur.freq + 1;
            cur.keys.remove(key);
        }
        if(cur.next.freq == newFreq){
            cur.next.keys.add(key);
        }else{ // insert a node with newFreq
            Node node = new Node(newFreq);
            node.keys.add(key);
            Node nextNode = cur.next;
            node.next = nextNode;
            nextNode.prev = node;
            cur.next = node;
            node.prev = cur;
        }
        map.put(key, cur.next);
        if(cur.keys.size()==0 && cur!=head){
            removeNode(cur);
        }
    }
    
    public void dec(String key) {
        Node cur = map.get(key);
        int newFreq = cur.freq - 1;
        cur.keys.remove(key);
        if(newFreq == 0){
            if(cur.keys.size()==0){
                removeNode(cur);
            }
            map.remove(key);
            return;
        }
    
        if(cur.prev.freq == newFreq){
            cur.prev.keys.add(key);
        }else{ // insert a node with newFreq
            Node node = new Node(newFreq);
            node.keys.add(key);
            Node prevNode = cur.prev;
            node.prev = prevNode;
            prevNode.next = node;
            node.next = cur;
            cur.prev = node;
        }
        map.put(key, cur.prev);
        if(cur.keys.size()==0 && cur!=head){
            removeNode(cur);
        }
    }
    
    public String getMaxKey() {
        if(tail.prev == head){
            return "";
        }
        return tail.prev.keys.iterator().next();
    }
    
    public String getMinKey() {
        if(head.next == tail){
            return "";
        }
        return head.next.keys.iterator().next();
    }
    private void removeNode(Node cur){
        Node nextNode = cur.next;
        Node prevNode = cur.prev;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        cur.next = null;
        cur.prev = null;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
